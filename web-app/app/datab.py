import sqlite3

#------------------------------------------------#
#					DataBase    				 #
#------------------------------------------------#


#-----------------------------------#
#				init				#
#-----------------------------------#
def init_db():
    conn = sqlite3.connect('datab.db')
    cursor = conn.cursor()
    cursor.execute('''
    CREATE TABLE IF NOT EXISTS users (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        email TEXT UNIQUE NOT NULL,
        username TEXT UNIQUE NOT NULL CHECK(LENGTH(username) >= 4 AND LENGTH(username) <= 25),
        firstname TEXT NOT NULL CHECK(LENGTH(firstname) <= 50),
        lastname TEXT NOT NULL CHECK(LENGTH(lastname) <= 50),
        password TEXT NOT NULL CHECK(LENGTH(password) = 162))
    ''')
    
    conn.commit()
    conn.close()