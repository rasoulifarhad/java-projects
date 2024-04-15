### Choose method names carefully

Simple rule of thumb:

- Builders are _nouns_
- Manipulators are _verbs_
  
_Builders_ are methods that build something and return a new object. 

```java
int pow(int base, int power);

float speed();

Employee employee(int id);

String parsedCell(int x, int y);
```

All of these names are wrong:

```java
InputStream load(URL url);

String read(File file);

int add(int x, int y);
```

They should be replaced with:

```java
InputStream stream(URL url);

String content(File file);

int sum(int x, int y);
```

_Manipulators_ are methods that makes modifications to the real-world entity being abstracted by an object. it always return _void_.

```java
void save(String content);

void put(String key, Float value);

void remove(Employee emp);

void quicklyPrint(int id);
```


> An object is a _living organism_ who knows how to preform his duties and wants to be respected. he wants to work by the contract, not just follow instructions.

<br/>

> An object is a representative of a real-world entity. whenwe need to manipulate a real-world entity, we ask the object to do it for us.

<br/>

```java

class Pixel {
	void paint(Color color) {

	}
}

Pixel center = new Pixel(50, 50);
center.paint(new Color("red"));
```

