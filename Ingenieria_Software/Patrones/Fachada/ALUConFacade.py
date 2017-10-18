from Facade import *

class ALUConF:# clase para simular una ALU con fachada

    def __init__(self):
        self.alu = AluFacade() #Inicializacion de el atributo, el cual es una instancia de la clase fachada.
    #los parametros 'a' y 'b' de la funcion son 2 enteros
    def sumar(self,a,b):# Metodo que calcula la suma entre 2 enteros
        self.alu.suma(a,b)# Se llama el metodo suma de la instancia alu de la clase fachada  
    #los parametros 'a' y 'b' de la funcion son 2 enteros
    def restar(self,a,b):# Metodo que calcula la resta entre 2 enteros
        self.alu.resta(a,b)# Se llama el metodo resta de la instancia alu de la clase fachada 
    #los parametros 'a' y 'b' de la funcion son 2 enteros
    def multiplicar(self,a,b):# Metodo que calcula la multiplicacion entre 2 enteros
        self.alu.multiplicacion(a,b)# Se llama el metodo multiplicacion de la instancia alu de la clase fachada 
    #los parametros 'a' y 'b' de la funcion son 2 enteros
    def dividir(self,a,b):# Metodo que calcula la division entre 2 enteros
        self.alu.division(a,b)# Se llama el metodo division de la instancia alu de la clase fachada 
    
if __name__ == "__main__":# Main
    al = ALUConF()# Instancia de la clase alu con fachada
    al.sumar(3,10)# se llama el metod sumar, y se le pasan 2 parametros, el metodo imprime inmediatamente el resultado
    al.restar(10,9)# se llama el metod restar, y se le pasan 2 parametros, el metodo imprime inmediatamente el resultado
