from AcumuladorA import *
from RegistroB import *

class AluFacade:# lase fachada para una ALU

    def __init__(self):
        self.acA = acumuladorA(0) # inicializacion de los atributos, acumulador A y registro B
        self.regB = registroB(0)#los atributos son uno de tipo acumulador y otro de tipo registro
    #los parametros 'a' y 'b' de la funcion son 2 enteros
    def suma(self,a,b): # Metodo que calcula la suma entre los datos que estan en el acumulador y el registro
        self.acA.setAcumularA(a)# se carga el acumulador A con el parametro 'a' del metodo
        self.regB.setRegistroB(b)# se carga el registro B con el parametro 'b' del metodo
        res = self.acA.getAcumuladorA() + self.regB.getRegistroB()#Se calcula la suma.
        self.regB.setRegistroB(0)
        self.acA.setAcumularA(res)# el resultado se guarda en el acumulador A.
        print self.acA.getAcumuladorA()# se imprime el resultado.
    #los parametros 'a' y 'b' de la funcion son 2 enteros
    def resta(self,a,b):# Metodo que calcula la resta entre los datos que estan en el acumulador y el registro
        self.acA.setAcumularA(a)# se carga el acumulador A con el parametro 'a' del metodo
        self.regB.setRegistroB(b)# se carga el registro B con el parametro 'b' del metodo
        res = self.acA.getAcumuladorA() - self.regB.getRegistroB()#Se calcula la resta.
        self.regB.setRegistroB(0)
        self.acA.setAcumularA(res)# el resultado se guarda en el acumulador A.
        print self.acA.getAcumuladorA()# se imprime el resultado.
    #los parametros 'a' y 'b' de la funcion son 2 enteros
    def multiplicacion(self,a,b):# Metodo que calcula la multiplicacion entre los datos que estan en el acumulador y el registro
        self.acA.setAcumularA(a)# se carga el acumulador A con el parametro 'a' del metodo
        self.regB.setRegistroB(b)# se carga el registro B con el parametro 'b' del metodo
        res = self.acA.getAcumuladorA() * self.regB.getRegistroB()#Se calcula la multiplicacion
        self.regB.setRegistroB(0)
        self.acA.setAcumularA(res)# el resultado se guarda en el acumulador A.
        print self.acA.getAcumuladorA() # se imprime el resultado.
    #los parametros 'a' y 'b' de la funcion son 2 enteros
    def division(self,a,b):# Metodo que calcula la division entre los datos que estan en el acumulador y el registro
        self.acA.setAcumularA(a)# se carga el acumulador A con el parametro 'a' del metodo
        self.regB.setRegistroB(b)# se carga el registro B con el parametro 'b' del metodo
        res = self.acA.getAcumuladorA() / self.regB.getRegistroB()# se calcula la division
        self.regB.setRegistroB(0)
        self.acA.setAcumularA(res)# el resultado se guarda en el acumulador A.
        print self.acA.getAcumuladorA()# se imprime el resultado.
  