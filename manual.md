
**Extensão:**  .davy


***
***
# **Sumário:**

1. [**Variáveis:**](#variáveis)  
    - [**entier;**](#entier)  
    - [**longue;**](#longue)  
    - [**string:**](#string)  
2. [**Entrada e Saída:**](#entrada-e-saída)  
    - [**lire;**](#lire)  
    - [**imprimer;**](#imprimer)  
    - [**imprimerVar;**](#imprimerVar)  
3. [**Operações;**](#operações)  
4. [**Condições;**](#condições)  
5. [**Controlador de Fluxo**](#controlador-de-fluxo)  
6. [**Laço;**](#laço)  


***
***


# **Variáveis**  
Para declarar variáveis, usamos:  
- Declaração de uma variável com valores nulos (null em strings e 0 para numéricos):
```
tipoVariavel nomeVariavel
```
- Declaração de uma variável com atribuição de valor:
```
tipoVariavel nomeVariavel = valorVariavel
```
***

## **entier**:
Tipo de variável utilizada para armazenar números inteiros.

```
entier x
x = 7 + 3 
entier y = 191
entier z = x + y
```
***

## **longue**:
Tipo de variável utilizada para armazenar números reais de até 8 bits

```
longue x
x = 10.9 + 1.987 
longue y = 191.5
longue z = x + y
```
***

## **string**:
Tipo de variável utilizada para armazenar palavras, frases, etc.

```
string a
a = "Davy" + "Melhor Linguagem"
string b = "Use davy :)"
string c = a + b
```
***

# **Entrada e Saída**  

## **lire:**  
Para receber entradas do teclado.  


```
longue x
lire(x)
```
**OBS:** antes de usar deve-se declarar a variável que receberá a entrada como no exemplo acima.

***

## **imprimer:**  
Para imprimir um texto entre "" (aspas) na tela


```
imprimer ("Hello World!")
```
**Saída na tela:**  
```
Hello World!
```

***

## **imprimerVar:**  
Para imprimir uma variável na tela


```
entier x = 10
imprimer (x)
```
**Saída na tela:**  
```
10
```
**OBS:** antes de usar deve-se declarar a variável;
***

# **Operações**  
Davy suporta vários tipos de operações:



<center>


|      Operador                   |    Significado  |  
| :----------------------------:|:---------------:| 
| **+**                       | Adição        |   
| **-**                       | Subtração     |  
| **\***                      | Multiplicação |   
| **/**                       | Divisão       | 
| **%**                       | Resto / módulo|   
| **++**                       | Incrementa 1|   
| **--**                       | Reduz 1|   

</center>

Atualmente **Davy** suporta uma operação por vez!  
Exemplo:

```
entier x = 10
entier y = 15
entier z = x + y
x = z + y
```


# **Condições**  


Existe também o suporte para operadores condicionais, dentre eles:
|      Operador               |  Significado  |  
| :--------------------------:|:-------------:| 
| **==**                      | Comparação de Igualdade    |   
| **>**                       | Maior         |  
| **>=**                      | Maior ou igual|  
| **<**                       | Menor         |  
| **<=**                      | Menor ou igual|  
| **!=**                      | Diferente     |    




```
oui(10 > 7)
    imprimer("ok!")
finoui
```
# **Controlador de Fluxo**  


Para controlar fluxos utilizamos a síntaxe:

|      Sintaxe                 |            |  
| ---------------------------- |:----------:| 
| **if**                       | oui        |   
| **else**                     | sinon      |  


Exemplos:   

> Se condiçãoA for satisfatória é executado o bloco;  
```
oui(condiçãoA)
    bloco
finoui
```


> Se condiçãoB for satisfatória é executado o bloco fazIsso, caso contrário é executado o bloco fazAquilo;  
```
oui(condiçãoB)
    fazIsso
sinon
    fazAquilo
finoui
```


# **Laço**

Davy suporta também a utilização do laço "pendant", similar ao While de outras linguagens.

Exemplo:
```
entier x = 1
pendant(x < 10)
    imprimer('davy, ')
    x++
finpendant
```
Saída:
```
davy, davy, davy, davy, davy, davy, davy, davy, davy, 
```
