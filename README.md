
# Elevator Algorithm

Commuting through campus buildings, I have come across a lot of elevators. Sometimes their algorithms of traversing floors didn't make sense to me. It fascinated me enough to research a little bit about them. Even create a simple program for a single elevator.
 
 
## Documentation

- Normally, a basic elevator uses the SCAN scheduling algorithm.

- "Efficiency" is not the most important feature in an elevator. The most important is to make sure every order is followed, that there is no starvation. If someone presses 100 and people keep pressing 1 and 2 it may be efficient to keep going between those floors, but it'd be nice for 100 to be visited at some point.

- From personal observation, I figure what most of them do is:
Start going in the direction of the first button pressed, keep track of which direction we're going
When a floor is reached and that button was pressed, stop and open the doors, mark the buttons for this floor as not pressed anymore.

If there are still more floors that we need to visit that are in the same direction, keep going in that direction.

If not and there are still floors we need to visit, move in that direction.

And finally, if not, then we're done and will start at 1 when a button is pressed again.

* Note that many elevators have buttons "I want to go up" and "I want to go down" next to the doors instead of a single button. The algorithm only needs a small change: in 2, if the only button pressed for that floor is one of the buttons next to the door, only stop and open the doors if we are going in that direction. Possibly keep the button pressed if the doors open because of a button pressed inside the elevator, and it is going in the wrong direction.


## References

 How an elevator works:
 https://dev.to/jimjja/how-does-an-elevator-works-1g40

The Destination Control System (DCS):
https://en.wikipedia.org/wiki/Elevator#Destination_control_system?wprov=sfla1
