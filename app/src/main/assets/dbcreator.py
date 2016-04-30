import sqlite3

CreateDataBase = sqlite3.connect('events_database')

QueryCurs = CreateDataBase.cursor()

def DropTable():
    QueryCurs.execute('''DROP TABLE IF EXISTS Events''')

def CreateTable():
    QueryCurs.execute('''CREATE TABLE IF NOT EXISTS Events
    (id INTEGER PRIMARY KEY, title TEXT, content TEXT,
    author TEXT, date DATETIME, category INT, media INT,
    mediaurl TEXT, location TEXT, lat READ, lng REAL)''')

def AddEntry(title,content,author,date,category,media,
             mediaurl,location,lat,lng):
    QueryCurs.execute('''INSERT INTO Events (title,content,
author,date,category,media,mediaurl,location,lat,lng)
    VALUES (?,?,?,?,?,?,?,?,?,?)''',(title,content,author,
                                     date,category,media,
                                     mediaurl,location,lat,lng))

DropTable()

CreateTable()

AddEntry('Soirée mousse','Allez viens','Pol\'hissez-haut',
         '2016-04-21 22:00:00',0,0,'www.google.fr',
         'L\'atelier',105.2,46.025668)

AddEntry('D\'une idée à une startup en 7 jours','blablabla','Jordan',
         '2016-04-19 18:00:00',0,0,'www.pornhub.com',
         'Amphi forum Templiers',105.2,46.025668)



CreateDataBase.commit()

QueryCurs.execute('SELECT * FROM Events ORDER BY date')

for i in QueryCurs:
    print("\n")
    for j in i:
        print(j)

QueryCurs.close()
