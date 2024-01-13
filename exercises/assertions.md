# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

### 1

L'assertion échoue en raison des erreurs de précisions sur les nombres flottants.

C'est pour cette raison qu'on utilise un delta lors de la vérification de l'égalité.

Par exemple :

``` java
assertTrue(Math.abs(3 * .4 - 1.2) < 1e-10);
```

### 2

assertEquals vérifie l'égalité entre deux objets en termes de valeurs tandis que assertSame vérifie si les deux objets en la même référence.

``` java
int b1 = 1;
int b2 = 2;
int b3 = b1;

//Même résultat
assertSame(b1,b3); //Correct
assertEquals(b1,b3): //Correct

//Résultat différent
assertSame(b1,b2); //Incorrect
assertEquals(b1,b2); //Correct
```

### 3

fail peut être utilisation pour marquer des test incomplet ou pour les cas par défaut dans un switch.

### 4

La nouvelle méthode permet d'améliorer la lisibilité des tests (on récupère l'exception dans le cas de test).
On sait où et comment est l'exception est levé.