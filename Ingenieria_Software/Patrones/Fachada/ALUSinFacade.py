from AcumuladorA import *
from RegistroB import *

class ALUNoF:# Clase para simular una ALU sin fachada

    def __init__(self):
        self.acA = None#Inicializacion de los atributos 
        self.regB = None
     #los parametros 'a' y 'b' de la funcion son una instancia de acumulador A y registro B respectivamente
    def suma(self,a,b):# Metodo que calcula la suma entre los datos que estan en el acumulador y el registro
        self.acA = a # se carga el acumulador A con el parametro 'a' del metodo
        self.regB = b # se carga el registro B con el parametro 'b' del metodo
        res = self.acA.getAcumuladorA() + self.regB.getRegistroB() # Se calcula la suma
        self.regB.setRegistroB(0)
        self.acA.setAcumularA(res)# el resultado se guarda en el acumulador A.
        return self.acA.getAcumuladorA()# se retorna el resultado.
    #los parametros 'a' y 'b' de la funcion son una instancia de acumulador A y registro B respectivamente
    def resta(self,a,b):# Metodo que calcula la resta entre los datos que estan en el acumulador y el registro
        self.acA = a# se carga el acumulador A con el parametro 'a' del metodo
        self.regB = b# se carga el registro B con el parametro 'b' del metodo
        res = self.acA.getAcumuladorA() - self.regB.getRegistroB()# se calcula la resta
        self.regB.setRegistroB(0)
        self.acA.setAcumularA(res)# el resultado se guarda en el acumulador A.
        return self.acA.getAcumuladorA()# se retorna el resultado.
    #los parametros 'a' y 'b' de la funcion son una instancia de acumulador A y registro B respectivamente
    def multiplicacion(self,a,b):# Metodo que calcula la multiplicacion entre los datos que estan en el acumulador y el registro
        self.acA = a# se carga el acumulador A con el parametro 'a' del metodo
        self.regB = b# se carga el registro B con el parametro 'b' del metodo
        res = self.acA.getAcumuladorA() * self.regB.getRegistroB()# se calcula la multiplicacion
        self.regB.setRegistroB(0)
        self.acA.setAcumularA(res)# el resultado se guarda en el acumulador A.
        return self.acA.getAcumuladorA()# se retorna el resultado.
    #los parametros 'a' y 'b' de la funcion son una instancia de acumulador A y registro B respectivamente    
    def division(self,a,b):# Metodo que calcula la division entre los datos que estan en el acumulador y el registro
        self.acA = a# se carga el acumulador A con el parametro 'a' del metodo
        self.regB = b# se carga el registro B con el parametro 'b' del metodo
        res = self.acA.getAcumuladorA() / self.regB.getRegistroB()# se calcula la division
        self.regB.setRegistroB(0)
        self.acA.setAcumularA(res)# el resultado se guarda en el acumulador A.
        return self.acA.getAcumuladorA()# se retorna el resultado.

    def mostrarResultado(self):# Metodo que muestra el resultado de una operacion almacenada en el acumulador A
        print self.acA.getAcumuladorA()

           
if __name__ == "__main__":#main 
    alu = ALUNoF()# Instancia de la clase alu sin fachada
    x = acumuladorA(3)# Instancia e inicializacion de acumulador A en este caso se inicializa con un valor de '3'
    y= registroB(10)# Instancia e inicializacion de registro B en este caso se inicializa con un valor de '10'
    alu.suma(x,y)# Se llama el metodo suma de la instacia de la clase.
    alu.mostrarResultado()# Se llama el metodo mostrarResultado para mostrar el resultado de la suma
    w = acumuladorA(10)# Instancia e inicializacion de acumulador A en este caso se inicializa con un valor de '10'
    z = registroB(9)# Instancia e inicializacion de registro B en este caso se inicializa con un valor de '9'
    alu.resta(w,z)# Se llama el metodo resta de la instacia de la clase.
    alu.mostrarResultado()# Se llama el metodo mostrarResultado para mostrar el resultado de la resta
