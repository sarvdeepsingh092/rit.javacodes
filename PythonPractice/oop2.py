__author__ = 'Sarvdeep Singh Bindra'

# -- VIEW--
class AnimalActions:
    def quack(self): return self.strings['quack']
    def feathers(self): return self.strings['feathers']
    def bark(self): return self.strings['bark']
    def fur(self): return self.strings['fur']

# --MODEL--

class Duck(AnimalActions):
    strings = dict(
        quack = "Quacccck!",
        feathers = "The duck has grey and white feathers",
        bark = "The duck cannot bark",
        fur = "The duck has no fur"
    )

class Person(AnimalActions):
    strings = dict(
        quack="The person imitates a duck",
        feathers="The picks up a feather and shows it",
        bark="The person imitates a dog",
        fur="The person plays with a fur"
    )

class Dog(AnimalActions):
    strings = dict(
        quack="the dog cannot bark",
        feathers="The dog does not have feathers ",
        bark="ARF!",
        fur="The dog does not have fur"
    )

# --CONTROLLER--

def in_the_doghouse(dog):
    print(dog.bark())
    print(dog.fur())


def in_the_forest(duck):
    print(duck.quack())
    print(duck.feathers())

def main():
    donald= Duck()
    john = Person()
    fido = Dog()

    print("In the forest")
    for o in(donald, john, fido):
        in_the_forest(o)

    print("In the doghouse")
    for o in (donald, john, fido):
        in_the_doghouse(o)

if __name__ == "__main__": main()