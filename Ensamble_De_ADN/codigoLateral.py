# -*- coding: utf-8 -*-
from time import time
from Graph import *

__docformat__ = "restructuredtext"

"""                                                                                                                                                  
:author: Hassler Castro Cuesta - Joshua Sanchez Alvarez - Juan Pablo Zapata Raigoza                                                                  
:version: 0.1                                                                                                                                        
"""


graph=Graph()
n = 106
thisIsSource = set()
thisIsDestination=set()
def read(root):
    """Este metodo se encarga de leer segmento por segmento y enviar cada segmento al metodo donde se insertaran al grafo"""
    first = time()
    f=open(root)
    for i in f:
        if i == "\n":
            continue
        i = i[:-1]
        toKmers(i)
    runPath()
    second = time()
    final = second - first
    print "Execution time:"
    print str(final)+" s"

def toKmers(string):
    """Este metodo recibe el segmento completo lo divide en K-Mers y lo agrega al grafo ademas cada nodo fuente y de destino es insertado en su respectivo conjunto  """
    for i in range(len(string)-(n+1)):
        source = string[i:i+n-1]
        destination = string[i+1:i+n]
        thisIsSource.add(source)
        thisIsDestination.add(destination)
        graph.add_Arc(source,destination, "")

def runPath():
    """Este metodo se encarga de recorrer el grafo desde su nodo inicial"""
    firstNode = thisIsSource - thisIsDestination
    begin = firstNode.pop()
    graph.Run(begin)
    graph.Codones()
    
f1="AY325307ADN-segments.txt"
f2="AB042837ADN.txt"
f3="10.txt"
f4="80.txt"
f5="180.txt"
f6="450.txt"
f7="1000.txt"
read(f1)




