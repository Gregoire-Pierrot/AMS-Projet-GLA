from flask_wtf import FlaskForm
from app import app, flask_secret_key
from wtforms import StringField, PasswordField, validators
from wtforms.validators import DataRequired, Email

class LoginForm(FlaskForm):
    email = StringField(label='email', validators=[DataRequired(message='* le champ "email" est obligatoire *'), Email(message="* l'email n'est pas valide *")])
    password = PasswordField(label='password', validators=[DataRequired(message='* le champ "password" est obligatoire *')])
    
app.config['SECRET_KEY'] = flask_secret_key
