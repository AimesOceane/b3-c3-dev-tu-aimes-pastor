# importation des libraries python pour le projet

import sys
import logging

# Configuration du Logger

logging.basicConfig(level=logging.DEBUG)
logger = logging.getLogger("calcul.inator")

#def dde la fonction qui prend les nombres et l'operateur de calcul

def get_number():
    var1 = int(input("first input : "))
    var2 = int(input("second input : "))
    operator = input('''
                Please select the type of operation you want to perform:
                + for addition
                - for subtraction
                * for multiplication
                / for division
''')
get_number()

def op(var1, operator, var2):
    if op == "+":
        print('{} + {} = '.format(var1, var2))
        print(var1 + var2)
    else : 
        print("Sa marche pas")
op()
