class acumuladorA: # componente acumulador a del sap

    def __init__(self,a):
        self.acum = a 

    def getAcumuladorA(self):
        return self.acum

    def setAcumularA(self,a):
        self.acum = a 


# ac = acumuladorA()
# ac.setAcumularA(40)
# print ac.getAcumuladorA()