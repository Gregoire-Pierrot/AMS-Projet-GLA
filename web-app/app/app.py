from flask import Flask
from config import Configuration
from dotenv import load_dotenv
import os

app = Flask(__name__)

app.config.from_object(Configuration)

load_dotenv()
flask_secret_key = os.getenv('FLASK_SECRET_KEY')
app.config['SECRET_KEY'] = flask_secret_key
