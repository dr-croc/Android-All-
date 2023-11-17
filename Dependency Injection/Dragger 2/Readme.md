## Contrutor Injection 
In case of construction injection you provide the value in the constructor <br />
#### Example : <br />
class Car(private val engine : Engine)<br />
{ <br />

}<br />

## Field Injection 
In case of Field injection you provide the value inside the class <br />
#### Example : <br />
class Car()<br />
{ <br />
private lateinit val engine : Engine <br />
}<br />

# Dragger 2
1. Compile time dependency injection
2. Compile time check if Dagger can create the required objects
3. Annotaion based.
4. Behave as s system for us to create object
5. Helps to injects these objects
6. Manage the life time of the object
7. Wrtie manageable code.


## Concept
1. Consumer. (which will consume the objects ) ( @Inject ) ( Dagger will know from the inject word that we need that object of the class. )
2. Producer. ( which will produce the objects ) ( @Module, @Provides, @Binds) 
3. Connecter. ( connect the consumer and producer ) (@Component)


