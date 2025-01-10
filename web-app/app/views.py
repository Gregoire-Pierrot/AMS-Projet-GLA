import email
from mimetypes import init
from app import app
from datab import init_db
from register import RegisterForm
from login import LoginForm
from account import AccountForm
from request_db import *
from functions import *
from flask import request, render_template, redirect, url_for, session, jsonify

init_db()

#--------------------------------------------#
#					Views					 #
#--------------------------------------------#

#-------------------------------#
#				/				#
#-------------------------------#
@app.route('/', methods=['GET'])
def homepage():
    if 'username' in session:
        return render_template('home.html', username=session['username'])
    return render_template('home.html')


#-------------------------------#
#			/register			#
#-------------------------------#
@app.route('/register', methods=['GET', 'POST'])
def register():
    if 'username' in session:
        return redirect(url_for('account'))
    form = RegisterForm()
    if form.validate_on_submit():
        email_t = EmailAlreadyUsed(request.form['email'])
        username_t = UsernameAlreadyUsed(request.form['username'])
        if email_t or username_t:
            return render_template('register.html', form=form, email_t=email_t, username_t=username_t)
        if Register(request.form['email'], request.form['username'], request.form['firstname'], request.form['lastname'], request.form['password']):
            return redirect(url_for('login'))
        return render_template('register.html', form=form, error=True)
    return render_template('register.html', form=form)


#-------------------------------#
#			/login				#
#-------------------------------#
@app.route('/login', methods=['GET', 'POST'])
def login():
    if 'username' in session:
        return redirect(url_for('account'))
    form = LoginForm()
    if form.validate_on_submit():
        if Login(request.form['email'], request.form['password']):
            session['username'] = GetUsernameByEmail(request.form['email'])
            return redirect(url_for('account'))
        elif EmailError(request.form['email']):
            return render_template('login.html', form=form, wrong_password=True)
        return render_template('login.html', form=form, email_e=True)
    return render_template('login.html', form=form)


#-------------------------------#
#			/account			#
#-------------------------------#
@app.route('/account', methods=['GET', 'POST'])
def account():
    if 'username' in session:
        username = session['username']
        email = GetEmailByUsername(username)
        form = AccountForm()
        if form.validate_on_submit():
            email_t = False
            if request.form['email'] != email:
                email_t = EmailAlreadyUsed(request.form['email'])
            username_t = False
            if request.form['username'] != username:
                username_t = UsernameAlreadyUsed(request.form['username'])
            if email_t or username_t:
                return render_template('account.html', email=GetEmailByUsername(username), username=username, firstname=GetFirstnameByUsername(username), lastname=GetLastnameByUsername(username), form=form, email_t=email_t, username_t=username_t)
            elif UpdateAccount(email, request.form['email'], request.form['username'], request.form['firstname'], request.form['lastname']):
                return redirect(url_for('account'))
            return render_template('account.html', form=form, error=True)
        return render_template('account.html', email=GetEmailByUsername(username), username=username, firstname=GetFirstnameByUsername(username), lastname=GetLastnameByUsername(username), form=form)
    return redirect(url_for('login'))


#-------------------------------#
#			/logout 			#
#-------------------------------#
@app.route('/logout', methods=['GET', 'POST'])
def logout():
    session.clear()
    return redirect(url_for('homepage'))


#-------------------------------#
#			/cryptohome			#
#-------------------------------#
@app.route('/cryptohome', methods=['GET'])
def cryptohome():
    username = None
    if 'username' in session:
        username = session['username']
    return render_template('cryptohome.html', username=username)


#-------------------------------#
#	    /cryptovision/<name>   	#
#-------------------------------#
@app.route('/cryptovision/<name>', methods=['GET'])
def cryptovision(name):
    username = None
    if 'username' in session:
        username = session['username']
    return render_template('cryptovision.html', cryptoname=name, username=username)


#-------------------------------#
#        /api/cryptohome        #
#-------------------------------#
@app.route('/api/cryptohome', methods=['GET'])
def api_cryptohome():
    cryptocurrencies_name_by_rank = getCryptocurrenciesNameByRank()
    cryptocurrencies_last_value = []
    for name in cryptocurrencies_name_by_rank:
        cryptocurrencies_last_value.append(getLastValue(name))

    response = {
        "values": cryptocurrencies_last_value
    }
    return jsonify(response)

#----------------------------------------#
#/api/values/cryptovision/<name>/<period>#
#----------------------------------------#
@app.route('/api/values/cryptovision/<name>/<period>', methods=['GET'])
def api_cryptovision(name, period):
    period = int(period)
    cryptocurrencies = getCryptocurrencies(name, period)
    values = []
    times = []
    for cryptocurrency in cryptocurrencies:
        values.append(cryptocurrency[8])
        times.append(cryptocurrency[11])
        
    values = values[::-1]
    times = times[::-1]
    
    response = {"name": cryptocurrency[0], "values": values, "times": times}
    print(response)
    
    return jsonify(response)


#--------------------------------------------#
#/api/percentage/cryptovision/<name>/<period>#
#--------------------------------------------#
@app.route('/api/percentage/cryptovision/<name>/<period>', methods=['GET'])
def api_cryptovision_percentage(name, period):
    period = int(period)
    cryptocurrencies = getCryptocurrencies(name, period)
    values = []
    times = []
    for cryptocurrency in cryptocurrencies:
        values.append(cryptocurrency[9])
        times.append(cryptocurrency[11])
    
    values = values[::-1]
    times = times[::-1]
        
    response = {"name": cryptocurrency[0], "values": values, "times": times}
    
    return jsonify(response)
