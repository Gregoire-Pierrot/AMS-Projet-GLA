import sqlite3
from datetime import datetime, timedelta

#------------------------------------------------#
#					Functions    				 #
#------------------------------------------------#


datas_path = 'datas.db'

#-------------------------------#
#		    getPeriod      		#
#-------------------------------#

def getPeriod(cryptocurrencies, period):
    now = datetime.now()
    start_time = now - timedelta(days=period)
    start_time_str = start_time.strftime("%d-%m-%Y %H:%M:%S")
    
    print(start_time_str)
    
    cryptocurrencies_on_period = []
    for cryptocurrency in cryptocurrencies:
        try:
            crypto_time = datetime.strptime(cryptocurrency[11], "%d-%m-%Y %H:%M:%S")
            print("Comparing:", crypto_time, "with", start_time)
            
            if crypto_time >= start_time:
                cryptocurrencies_on_period.append(cryptocurrency)
        except ValueError as e:
            print(f"Erreur lors de la conversion de {cryptocurrency[11]} : {e}")
    
    return cryptocurrencies_on_period

#-------------------------------#
#		getCryptocurrencies		#
#-------------------------------#

def getCryptocurrencies(name, period):    
    conn = sqlite3.connect(datas_path)
    cursor = conn.cursor()
    
    cryptocurrencies = cursor.execute('''
    SELECT c.id, c.symbol, c.name, c.rank, cd.supply, cd.maxSupply, cd.marketCapUsd, cd.volumeUsd24Hr, cd.priceUsd, cd.changePercent24Hr, cd.vwap24Hr, t.timestamp
    FROM cryptocurrency c
    JOIN cryptocurrencydata cd ON c.id = cd.cryptocurrency_id
    JOIN time t ON cd.time_id = t.id
    WHERE c.name = ?
    ORDER BY t.timestamp DESC
    ''', (name,)).fetchall()
    
    cryptocurrencies_on_period = getPeriod(cryptocurrencies, period)
    
    conn.close()
    
    return cryptocurrencies_on_period


#-------------------------------#
#   getCryptocurrenciesName 	#
#-------------------------------#

def getCryptocurrenciesName():
    conn = sqlite3.connect(datas_path)
    cursor = conn.cursor()
    
    cryptocurrencies_name = cursor.execute('''
    SELECT name
    FROM cryptocurrency
    ''').fetchall()
    
    conn.close()
    
    names = []
    for cryptocurrency in cryptocurrencies_name:
        names.append(cryptocurrency[0])
    
    return names


#-------------------------------#
#           getRank         	#
#-------------------------------#

def getRank(name):
    conn = sqlite3.connect(datas_path)
    cursor = conn.cursor()
    
    rank = cursor.execute('''
    SELECT rank
    FROM cryptocurrency
    WHERE name = ?
    ''', (name,)).fetchall()
    
    return rank
    

#-------------------------------#
#   getCryptocurrenciesByRank   #
#-------------------------------#

def getCryptocurrenciesNameByRank():
    conn = sqlite3.connect(datas_path)
    cursor = conn.cursor()
    
    cryptocurrencies = cursor.execute('''
    SELECT c.name
    FROM cryptocurrency c
    JOIN cryptocurrencydata cd ON c.id = cd.cryptocurrency_id
    ORDER BY c.rank ASC
    ''', ()).fetchall()
    
    conn.close()
    
    names = []    
    for cryptocurrency in cryptocurrencies:
        if cryptocurrency[0] not in names:
            names.append(cryptocurrency[0])
    
    return names


#-----------------------------#
#       getLastValue          #
#-----------------------------#

def getLastValue(name):
    conn = sqlite3.connect(datas_path)
    cursor = conn.cursor()
    
    last_value = cursor.execute('''
    SELECT c.rank, c.name, c.symbol, cd.priceUsd, cd.changePercent24Hr, cd.supply
    FROM cryptocurrency c
    JOIN cryptocurrencydata cd ON c.id = cd.cryptocurrency_id
    JOIN time t ON cd.time_id = t.id
    WHERE c.name = ?
    ORDER BY t.timestamp DESC
    LIMIT 1
    ''', (name,)).fetchall()

    conn.close()
    
    values = []
    for value in last_value:
        values.append(value[0])
        values.append(value[1])
        values.append(value[2])
        values.append(value[3])
        values.append(value[4])
        values.append(value[5])
    
    return values