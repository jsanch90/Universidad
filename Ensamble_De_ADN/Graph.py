# -*- coding: utf-8 -*-
#implementacion de grafo con diccionario de dicionarios
#en el diccionario principal se guardan los verices como clave principal y otro diciconario como valor de la clave, este valor a su vez
#tiene como clave el verice al que se llega y el peso como valor de la clave .

__docformat__ = "restructuredtext"

"""                                                                                                                                                  
:author: Hassler Castro Cuesta - Joshua Sanchez Alvarez - Juan Pablo Zapata Raigoza                                                                  
:version: 0.1                                                                                                                                        
"""


class Graph():
        """Clase grafo implementada con dicionarios"""
	def __init__(self):#constructor
                """Inicializador de la clase
                :param size1: tamaño del grafo
                """
		self.g=dict()#crea el diccionario principal del grafo
		
	def add_Arc(self,source, destination,weight):
                """Se crea un arco entre 2 vertices
                :param source:vertice fuente
                :param destination: verice a donde se llega
                :param weight: peso del arco entre los vertices relacionados
                """
                if not self.g.has_key(source):#si el verice no esta agregado se agrega
			self.g[source]=dict()
                self.g[source][destination]=weight#se relacionan dos vertices 

	def getSuccessors(self,vertex):
                """Retorna una lista con los sucesores de un vertice
                :param vertex: vetice del cual se desean los sucesores
                """
		default=[]#esta lista se retorna si el elemento no es una clave en el diccionario
		if not self.g.has_key(vertex):#aqui si compara si el elemnto esta en el diccionario como clave
			return default
		return list(self.g[vertex].keys())#se retornan todos los sucesores o vecinos de un vertice
        
        def Codones(self):
                """Metodo para buscar los genes del adn a partir de una cadena ensamblada, abre 2 archivos , uno f que es el que contiene la cadena completa y otro output que es en el cual se escribiran los genes encontrados, los genes generalmente inician con el codon "atg" """
                f=open('salida.txt')
                f1 = open('output.txt','w')
                y =f.readline()
                encontroAUG =False
                codon="atg"
                i=0
                while i < len(y)-3:
                        if encontroAUG==False:
                                if(y[i]=="a" and y[i+1]=="t" and y[i+2]=="g"):
                                        encontroAUG = True
                                        i+=3
                                else:
                                        i+=1
                                        continue
                        if encontroAUG==True:
                                if (((y[i]=='t' and y[i+1]=='g' and y[i+2]=='a') or (y[i]=='t' and y[i+1]=='a' and y[i+2]=='g' ) or(y[i]=='t' and y[i+1]=='a' and y[i+2]=='a')) and len(codon)) > 300:
                                        f1.write(codon + y[i] + y[i+1] + y[i+2] + '\n')
                                        i+=3
                                        encontroAUG = False
                                        codon="atg"
                                else:
                                        codon+=y[i]
                                        i+=1

                                        
        def Run(self,vertex):
                """Metodo para recorre el grafo y escribir la cadena ensamblada en un fichero de texto plano"""
                fx = open('salida.txt','w')
                fx.write(vertex)
                vertex = self.getSuccessors(vertex)[0]
                while True:
                        if self.getSuccessors(vertex) == []:
                                fx.write(vertex[-1])
                                break
                        else:
                                fx.write(vertex[-1])
                                vertex=self.getSuccessors(vertex)[0]
                fx.close()
                
