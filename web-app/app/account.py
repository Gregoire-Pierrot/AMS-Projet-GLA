from flask_wtf import FlaskForm
from app import app, flask_secret_key
from wtforms import StringField
from wtforms.validators import DataRequired, Email, Length

class AccountForm(FlaskForm):
    email = StringField(label='email', validators=[DataRequired(message='* le champ "email" est obligatoire *'), Email(message="* l'email n'est pas valide *")])
    username = StringField(label='username', validators=[DataRequired(message='* le champ "nom d'"'"'utilisateur'" est obligatoire *"), Length(min=4, max=25, message="* le nom d'utilisateur doit avoir entre 4 et 25 caractères *")])
    firstname = StringField(label='firstname', validators=[DataRequired(message='* le champ "prénom" est obligatoire *'), Length(max=50, message="* le prénom doit avoir au maximum 50 caractères *")])
    lastname = StringField(label='lastname', validators=[DataRequired(message='* le champ "nom" est obligatoire *'), Length(max=50, message="* le nom doir avoir au maximum 50 caractères *")])
    
app.config['SECRET_KEY'] = flask_secret_key
