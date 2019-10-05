# I take hint from observer design pattern.
# hallways are observers and buttons are observable

# BUTTONS
# every button has a list of hallways it can control.
# We call 'register(hallway)' to register each hallway for each button.
# whenever a button is on, it notifies all the registered hallways and increases their hit by 1
class Buttons():
    def __init__(self):
        self.hallways = []

    def register(self, hallway):
        self.hallways.append(hallway)

    def notify(self):
        for hall in self.hallways:
            hall.update()


# HALLWAYS
# We keep the track of number of times the hallway has been turned on by a button, in 'hit'
# Whenever a button is turned on notify() of that button call update() of each hallway and increase 'hit' by 1
# getState() let us know whether the hallway light is 'on' or 'off'
class Hallways:
    def __init__(self):
        self.hit = 0
    def update(self):
        self.hit += 1
    def getState(self):
        if self.hit == 0 or self.hit == 2:
            return "OFF"
        elif self.hit == 1:
            return "ON"

def main():
    # creating objects for each hallway
    se = Hallways()
    sw = Hallways()
    ne = Hallways()
    nw = Hallways()

    # creating objects for each button and registering corresponding hallway
    b1 = Buttons()
    b1.register(nw)
    b1.register(se)

    b2 = Buttons()
    b2.register(ne)
    b2.register(sw)

    b3 = Buttons()
    b3.register(se)
    b3.register(ne)

    b4 = Buttons()
    b4.register(sw)
    b4.register(nw)

    # we convert the input to lowercase to reduce number of checks
    # we notify the button whenever it is turned on which in turn updates the hallways
    b1_input, b2_input, b3_input, b4_input = "",",","",""
    while not(b1_input == "on" or b1_input == "off"):
        b1_input = input("Enter the state of B1 (on|off) : ").lower()
        if b1_input == "on":
            b1.notify()

    while not (b2_input == "on" or b2_input == "off"):
        b2_input = input("Enter the state of B2 (on|off) : ").lower()
        if b2_input == "on":
            b2.notify()

    while not (b3_input == "on" or b3_input == "off"):
        b3_input = input("Enter the state of B3 (on|off) : ").lower()
        if b3_input == "on":
            b3.notify()

    while not (b4_input == "on" or b4_input == "off"):
        b4_input = input("Enter the state of B4 (on|off) : ").lower()
        if b4_input == "on":
            b4.notify()

    print("\n")
    # to know whether the hallway is on or off, we call getState() of each hallway
    print("Light Status of NW Hallway : ", nw.getState())
    print("Light Status of NE Hallway : ", ne.getState())
    print("Light Status of SE Hallway : ", se.getState())
    print("Light Status of SW Hallway : ", sw.getState())

if __name__ == '__main__':
    main()
