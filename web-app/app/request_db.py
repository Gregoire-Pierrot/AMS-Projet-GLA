import sqlite3
import json
from werkzeug.security import generate_password_hash, check_password_hash

#--------------------------------------------#
#					Request    				 #
#--------------------------------------------#


#---------------------------------------#
#				Register 				#
#---------------------------------------#
def Register(email, username, firstname, lastname, password):
    conn = sqlite3.connect('datab.db')
    cursor = conn.cursor()
    
    # At this point, the email and the username were alwready verified.

    hashed_password = generate_password_hash(password)
    print(len(hashed_password))
    cursor.execute('''
    INSERT INTO users (email, username, firstname, lastname, password)
    VALUES (?, ?, ?, ?, ?)
    ''', (email, username, firstname, lastname, hashed_password))
    conn.commit()
    conn.close()
    
    print("---------------------------")
    print("Nouvel utilisateur créer !")
    print("Username : ", username)
    print("---------------------------")
    
    return True


#---------------------------------------#
#				  Login    				#
#---------------------------------------#

def Login(email, password):
    conn = sqlite3.connect('datab.db')
    conn.row_factory = sqlite3.Row
    cursor = conn.cursor()
    
    row = cursor.execute("SELECT * FROM users WHERE email = ?", (email,)).fetchone()
    
    conn.close()
    
    if row is None:
        return False
    
    row_dict = dict(row)
    if check_password_hash(row_dict['password'], password):
        return True


#---------------------------------------------------#
#				  EmailAlreadyUsed    				#
#---------------------------------------------------#
def EmailAlreadyUsed(email):
    conn = sqlite3.connect('datab.db')
    conn.row_factory = sqlite3.Row
    cursor = conn.cursor()
    
    row = cursor.execute("SELECT email FROM users WHERE email = ?", (email,)).fetchone()
    
    if row is None:
        return False
    return True


#-------------------------------------------------------#
#				  UsernameAlreadyUsed    				#
#-------------------------------------------------------#
def UsernameAlreadyUsed(username):
    conn = sqlite3.connect('datab.db')
    conn.row_factory = sqlite3.Row
    cursor = conn.cursor()
    
    row = cursor.execute("SELECT username FROM users WHERE username = ?", (username,)).fetchone()
    
    if row is None:
        return False
    return True


#-------------------------------------------------------#
#				  GetUsernameByEmail    				#
#-------------------------------------------------------#
def GetUsernameByEmail(email):
    conn = sqlite3.connect('datab.db')
    conn.row_factory = sqlite3.Row
    cursor = conn.cursor()
    
    return cursor.execute("SELECT username FROM users WHERE email = ?", (email,)).fetchone()['username']


#-------------------------------------------------------#
#				  GetEmailByUsername    				#
#-------------------------------------------------------#
def GetEmailByUsername(username):
    conn = sqlite3.connect('datab.db')
    conn.row_factory = sqlite3.Row
    cursor = conn.cursor()
    
    return cursor.execute("SELECT email FROM users WHERE username = ?", (username,)).fetchone()['email']


#-------------------------------------------------------#
#				  GetFirstnameByUsername    				#
#-------------------------------------------------------#
def GetFirstnameByUsername(username):
    conn = sqlite3.connect('datab.db')
    conn.row_factory = sqlite3.Row
    cursor = conn.cursor()
    
    return cursor.execute("SELECT firstname FROM users WHERE username = ?", (username,)).fetchone()['firstname']


#-------------------------------------------------------#
#				  GetLastnameByUsername    				#
#-------------------------------------------------------#
def GetLastnameByUsername(username):
    conn = sqlite3.connect('datab.db')
    conn.row_factory = sqlite3.Row
    cursor = conn.cursor()
    
    return cursor.execute("SELECT lastname FROM users WHERE username = ?", (username,)).fetchone()['lastname']


#-----------------------------------------------#
#				  EmailError    				#
#-----------------------------------------------#
def EmailError(email):
    conn = sqlite3.connect('datab.db')
    conn.row_factory = sqlite3.Row
    cursor = conn.cursor()
    
    row = cursor.execute("SELECT email FROM users WHERE email = ?", (email,)).fetchone()
    
    if row:
        return False
    return True
