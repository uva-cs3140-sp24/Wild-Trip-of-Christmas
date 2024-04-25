Group members: Ziqian Zhao
Game Name: Kulomi’s Christmas Adventure

Game Description:
It’s mainly a treasure haunting pixel game.
To run our game, please use “W”, “A”, “S”, “D” four keys to control the Kulomi’s movement of up, down, left, and right.
The main goal of our game is to pick up all of 6 Hearts and that’s how to win the game. The Boot can add Kulomi’s moving speed.

Classes we wrote and their purpose/what they do:
1.Project3: main class

2.GamePanel: combine everything together and make them interconnected => set sizes, manage key input and tiles, paint the Kulomi, play music and sound effects.

3.Player: define our character Kulomi, add its images and movements based on keyboard actions, and create the Pickup function to make the effect of collecting Heart and Boot and then have the following signal on them.

4.Entity: define all our important variables and initialize them.

5.KeyHandler: implements keylistener to match every user keyboard input with an action of Kulomi in our game.

6.Tile: initialize image and collision for our tiles.

7.Map: a plain text file which create the arrangement for the map(the screen look)
8.CollisionChecker: Create the fundamental function to check the Kulomi’s movement and whether she encounters an obstacle and corresponds accordingly.

9.TileManager: fill the screen with corresponding images and define their property on collection detection, and help draw the map within the screen size.

10.SuperObject, OBJ_Heart, OBJ_Boots: define our functional objects, add them actions and image, define their collision detectable solid area.

11.UI: is created for string outputs, which are remainders for user when they have some successes, gains, and wins. It settles the color, font, size, and position for texts.

12.AssetSetter: put Heart and Boots objects into specific place on map with x and y axis defined by ourselves.

13.Sound: add music pieces from wav. 16bit resources downloaded.


Meet the Major Requirements:
1. There is animation 
=> Yes. We create the main class as Project 3 and the GamePanel class which extends JPanel and implements Runnable to achieve the animation effect. Ziqian also draw all six movement pictures on Procreate.

2. It is interactive (i.e., keyboard/mouse.) 
=> Yes. We create KeyHandler class to implement KeyListener to process the user keyboard input.

3. There is a scoring mechanism and it is shown to the player 
=> Yes. Every time when the player picks up a Heart, the player will get 1 point and that will be shown on the left top corner of the screen “Heart(image) X1” and a String reminding “You got a heart!”. Those would clearly tell the player their game progress. Besides, the score will increase as the player picks up more hearts.

4. There is a definitive ending mechanism (i.e., you can win or lose). 
=> Yes. When the user successfully picks up all 6 Hearts, she/he wins the game. And when she/he wins, there will be a String of “Congratulations!” and “Wish you a merry Christmas!” on the center of the screen” with the Sound of a Christmas song playing along with them.

5. There is a physical mechanism (i.e., velocity, mass, motion, gravity).
=> Yes. The Kulomi herself has an initial velocity. Besides, her speed can be increased by 1 by collecting the Boot object.

6. There is collision detection (i.e., walls, items, rewards, hazards.)
=> Yes. We create a Collision Checker class to determine which of the tiles in the map cannot be passed through(collision-detectable tiles include a snowman, Christmas tree, ginger cookie man, and house).

7.It is creative.
=> Yes. We create a concrete map with uniquely designed objects and tiles to decorate the game. 

The flourish we chose to implement:
1.Sound effect
We created a Sound class to add sound effect for the background, when the player pick up Heart, and when the player win the game.

2.Make it look cool
We drew all the pixel tiles on Procreate and object picture to make our game look joyful. Since it is going to be Christmas Eva, we made it more look like a Christmas town. 

