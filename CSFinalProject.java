/* G1PracticeTest class
 * @description Final Culminating Assignment.
 * @authors Amun Ahmad & Daniel Kovalevskiy
 * @version January 13, 2022
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.border.Border;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;

public class CSFinalProject {
    static JFrame gameFrame = new JFrame("G1 Program");

    static JLabel questionDisplay;
    static JLabel endResults;
    static JLabel picLabel;
    static JLabel buttonHighlight;
    static JLabel progress;
    static BufferedImage imageQuestion;
    static BufferedImage backgroundImage;
    static int imageWidth;
    static int imageHeight;
    static int progressBarX;

    static GraphicsPanelOne northCanvas;
    static GraphicsPanelTwo centerCanvas;
    static GraphicsPanelThree southCanvas;

    static JButton exitButton;
    static JButton choiceOne;
    static JButton choiceTwo;
    static JButton choiceThree;
    static JButton choiceFour;

    static int correctButton;
    static int answeredCorrect;

    static int highlightX;
    static int highlightY;

    static int[] usedQuestionsKnowledge;
    static int[] usedQuestionsSigns;
    static JButton[] buttonArray;

    static int gameMode = 0;
    static boolean endMenu = false;

    static String answeredDisplay = "";

    static int questionCounter = 0;
    static int questionKnowledgeCounter = 0;
    static int questionSignsCounter = 0;

    static int questionRange = 59;
    static boolean questionAnswered = false;
    static boolean drawRect = false;

    static String answerOne;
    static String answerTwo;
    static String answerThree;
    static String answerFour;

    static final Color outlineColor = new Color(50, 50, 50, 100);
    static final Color myRed = new Color(234, 70, 75, 200);
    static final Color myGreen = new Color(150, 220, 125, 200);
    static final Color lightBlue = new Color (120, 200, 235);

    static String[] knowledgeQuestions = {
        "<html>Q1: Upon approaching a stop sign, what does the law require you to do before entering an intersection?</html>",
        "<html>Q2: When entering a freeway you should…?</html>",
        "<html>Q3: When deciding to make a U turn, your first consideration should be to check…?</html>",
        "<html>Q4: A red signal light with a green arrow is shown at an intersection indicates…?</html>",
        "<html>Q5: The nearest a driver may park to a fire hydrant is…?</html>",
        "<html>Q6: A flashing yellow beacon above an intersection…?</html>",
        "<html>Q7: By law, you must report any collision to the police when there are injuries or damage to vehicles or other property exceeding…?</html>",
        "<html>Q8: While you are driving with a G1 license, you must not drive between…?</html>",
        "<html>Q9: On a roadway where traffic is moving in both directions, in what position must you be before making a left turn?</html>",
        "<html>Q10: Threshold braking means…?</html>",
        "<html>Q11: Under all conditions you should drive at a speed that will allow you to…?</html>",
        "<html>Q12: A flashing blue light mounted on a motor vehicle indicates what?</html>",
        "<html>Q13: Where there are no posted speed limits, the maximum speed in cities, towns and villages is…?</html>",
        "<html>Q14: Drivers who do not buckle up can be fined and given…?</html>",
        "<html>Q15: If a tire blows out you should…?</html>",
        "<html>Q16: What is meant by 'overdriving' your headlights?</html>",
        "<html>Q17: Never change lanes without…?</html>",
        "<html>Q18: Always be aware of traffic around you as you drive, check your mirrors every ______ seconds or so.</html>",
        "<html>Q19: What you cannot see in your vehicle rear and side-view mirrors is said to be in your…?</html>",
        "<html>Q20: What should you do when exiting a freeway?</html>",
        "<html>Q21: Coming to a complete stop at an intersection is required, but where do you stop if there is no stop line, crosswalk or sidewalk?</html>",
        "<html>Q22: What action should be taken if your brakes fail?</html>",
        "<html>Q23: If there are continuity lines to the right of your lane, what must you do?</html>",
        "<html>Q24: How much room do cyclists need on either side of themselves as a safety zone?</html>",
        "<html>Q25: You are approaching an intersection on a main road, and the intersection is blocked with traffic. You should…?</html>",
        "<html>Q26: When a right turn against a red signal light is permitted, what does the law require you to do before entering the intersection and making a turn?</html>",
        "<html>Q27: When parking facing downhill you should…?</html>",
        "<html>Q28: When descending a steep hill, a good and safe driving practice is to…?</html>",
        "<html>Q29: Before moving from a parked position you should…?</html>",
        "<html>Q30: If you do not tell the truth about your vehicle insurance or if you show false documents...?</html>",
        "<html>Q31: The Accessible Parking Permit allows…?</html>",
        "<html>Q32: What should you do if you become stranded in snow?</html>",
        "<html>Q33: When a police officer signals you to pull your vehicle over you must…?</html>",
        "<html>Q34: What should you do if you feel drowsy while driving?</html>",
        "<html>Q35: How many demerit points will be recorded on your license for failing to remain at the scene of a collision?</html>",
        "<html>Q36: When do you stop for a school bus if there is a median?</html>",
        "<html>Q37: How many days do new Ontario residents have to register their vehicles</html>",
        "<html>Q38: Road test failures may result from…?</html>",
        "<html>Q39: High Occupancy Vehicle lanes on provincial highways are reserved for vehicles carrying how many passengers?</html>",
        "<html>Q40: If a front tire goes flat, your vehicle will pull strongly to the________</html>",
        "<html>Q41: If you fail or refuse to give a breath or blood sample when asked by police, your license will immediately be suspended for…?</html>",
        "<html>Q42: Signs giving instructions around roadworks are…?</html>",
        "<html>Q43: What is the safest action to take when your vehicle drives over black ice?</html>",
        "<html>Q44: When can you pass on a shoulder?</html>",
        "<html>Q45: If you are 80 years of age or older, you are required to renew your driver's licence every…?</html>",
        "<html>Q46: It is more dangerous to drive at the maximum speed limit at night than during the day because…?</html>",
        "<html>Q47: Winter traction is affected by slippery conditions; in winter drivers should drive…?</html>",
        "<html>Q48: What must a driver do before entering a highway from a private road or driveway?</html>",
        "<html>Q49: Are drivers responsible for their passengers buckling up?</html>",
        "<html>Q50: Never make a U-turn unless you can see at least _______ in both directions.</html>",
        "<html>Q51: If you are convicted of careless driving, you will get...?</html>",
        "<html>Q52: If your blood alcohol concentration is more than 80 milligrams in 100 millilitres of blood (.08)…?</html>",
        "<html>Q53: What is the driver of a motor vehicle not permitted to carry in a house or boat trailer?</html>",
        "<html>Q54: If your vehicle becomes disabled on a 400-series highway, you should…?</html>",
        "<html>Q55: When lights are required, drivers are required to switch to low beam headlights…?</html>",
        "<html>Q56: A licensed driver changes his or her name or address. They must inform the Ministry of Transportation…?</html>",
        "<html>Q57: When on streets designed for two-way traffic, if you hear the siren of an emergency vehicle, what does the law require you to do?</html>",
        "<html>Q58: Upon approaching a yield sign, what does the law require you to do?</html>",
        "<html>Q59: Pedestrians walking on a highway should normally walk…?</html>",
        "<html>Q60: Motorcyclists are entitled to the use of…?.</html>"
    };

    static String[][] knowledgeAnswers = {
        {   
            "<html>1CORRECT; Stop, and when it is safe to do so, proceed</html>",
            "<html>1; Stop, sound horn, then proceed</html>",
            "<html>1; Slow down and if way is clear, proceed</html>",
            "<html>1; Slow down, sound horn and proceed</html>"
        }, 
        {
            "<html>2; Drive slowly and be prepared to stop for freeway traffic</html>",
            "<html>2; Slow down, and then enter freeway at a sharp angle</html>",
            "<html>2CORRECT; Signal and increase your speed to merge smoothly with traffic</html>",
            "<html>2; Stop on the acceleration lane, wait for an opening, and then enter the freeway rapidly</html>"
        },
        {   
            "<html>3CORRECT;The traffic regulations</html>",
            "<html>3; The turning radius of your vehicle</html>",
            "<html>3; The height of the curb</html>",
            "<html>3; The weather conditions</html>"
        },
        {
            "<html>4; Stop and wait for a green signal before making a turn in the direction of the arrow</html>",
            "<html>4; That pedestrians may cross</html>",
            "<html>4; Stop and then proceed</html>",
            "<html>4CORRECT; Proceed with caution in the direction of the arrow</html>"
        },
        {
            "<html>5; 1.5 m</html>",
            "<html>5; 6 m</html>",
            "<html>5; 4.5 m</html>",
            "<html>5CORRECT; 3 m</html>"
        },
        {
            "<html>6CORRECT; Warns you to drive with caution</html>",
            "<html>6; Tells you to stop if making left turn</html>",
            "<html>6; Tells you to stop if making left turn</html>",
            "<html>6; Tells you to continue at same speed</html>"
        },
        {
            "<html>7; $200</html>",
            "<html>7; $100</html>",
            "<html>7; $5000</html>",
            "<html>7CORRECT; $2000</html>"
        },
        {
            "<html>8CORRECT; Midnight and 5:00 a.m.</html>",
            "<html>8; 9:00 a.m. and 5:00 p.m.</html>",
            "<html>8; 5:00 p.m. and midnight.</html>",
            "<html>8; 5:00 a.m. and 9:00 a.m.</html>"
        },
        {
            "<html>9; Close to the right-hand side of the roadway</html>",
            "<html>9; Close to the left side of the roadway</html>",
            "<html>9CORRECT; Immediately to the right of the centerline of the roadway</html>",
            "<html>9; It does not matter provided you signal</html>"
        },
        {
            "<html>10; You are braking dangerously</html>",
            "<html>10CORRECT; You use all the braking force available without locking the wheels</html>",
            "<html>10; You pump the brakes several times</html>",
            "<html>10; You brake hard and stay on the brakes until the vehicle stops</html>"
        },
        {
            "<html>11; Stop within 150 m</html>",
            "<html>11; Stop within 90 m</html>",
            "<html>11; Stop within 60 m</html>",
            "<html>11CORRECT; Stop within a safe distance</html>"
        },
        {
            "<html>12; An ambulance</html>",
            "<html>12; A motor vehicle carrying explosives</html>",
            "<html>12; A police emergency vehicle</html>",
            "<html>12CORRECT; Snow removal equipment</html>"
        },
        {
            "<html>13; 60km/h</html>",
            "<html>13CORRECT; 50km/h</html>",
            "<html>13; 40km/h</html>",
            "<html>13; 30km/h</html>"
        },
        {
            "<html>14; Three demerit points</html>",
            "<html>14; Four demerit points</html>",
            "<html>14CORRECT; Two demerit points</html>",
            "<html>14; One demerit point</html>"
        },
        {
            "<html>15; Apply heavy braking</html>",
            "<html>15; Keep your foot on the brake and steer to left</html>",
            "<html>15; Keep your foot on the brake and steer to right</html>",
            "<html>15CORRECT; Take your foot off the gas pedal to slow down and steer the vehicle firmly in the direction you want to go</html>"
        },
        {
            "<html>16; Using your headlights when unnecessary</html>",
            "<html>16; Flashing your headlights constantly</html>",
            "<html>16CORRECT; Driving so fast that your stopping distance is farther than you can see with your headlights</html>",
            "<html>16; Driving with high beam headlights at all times</html>"
        },
        {
            "<html>17; Blowing your horn and providing the appropriate hand signal</html>",
            "<html>17; Signaling and decreasing speed</html>",
            "<html>17CORRECT; Signaling, checking the rear view mirror and checking blind spots</html>",
            "<html>17; Checking the rear view mirror</html>"
        },
        {
            "<html>18; 6</html>",
            "<html>18; 3</html>",
            "<html>18; 10</html>",
            "<html>18CORRECT; 5</html>"
        },
        {
            "<html>19; Danger zone</html>",
            "<html>19; Safe zone</html>",
            "<html>19CORRECT; Blind spot</html>",
            "<html>19; Dark area</html>"
        },
        {
            "<html>20; Signal, and then accelerate while merging smoothly into traffic and then proceed to the exit lane</html>",
            "<html>20CORRECT; Signal, move into the deceleration lane, reduce speed gradually and obey exit signs</html>",
            "<html>20; Signal and then stop to wait for an opening in traffic</html>",
            "<html>20; Do what the vehicle ahead of you does</html></html>"
        },
        {
            "<html>21; Right beside the stop sign</html>",
            "<html>21; A little into the intersection</html>",
            "<html>21CORRECT; At the edge of the intersection</html>",
            "<html>21; Right before the stop sign</html>"
        },
        {
            "<html>22CORRECT; Pump the brakes rapidly and shift into a lower gear</html>",
            "<html>22; Wave down the nearest police officer and shout for help</html>",
            "<html>22; Use your emergency brake and sound your horn to warn other drivers while looking for a soft collision point</html>",
            "<html>22; Firmly press down on your brakes until they re-engage</html>"
        },
        {
            "<html>23CORRECT; You are not required to do anything unless you want to exit. Your lane is unaffected</html>",
            "<html>23; You must merge with the traffic to your right</html>",
            "<html>23; You must change the lane as your lane is exiting or ending</html>",
            "<html>23; You must merge with the traffic to your left</html>"
        },
        {
            "<html>24CORRECT; 1 meter</html>",
            "<html>24; 3 metres</html>",
            "<html>24; 4 metres</html>",
            "<html>24; 2 metres</html>"
        },
        {
            "<html>25; Keep as close as possible to the car ahead</html>",
            "<html>25; Sound your horn to warn cars ahead to move on</html>",
            "<html>25CORRECT; Proceed slowly into the intersection until the traffic ahead moves on</html>",
            "<html>25; Slam your breaks like a sadistic maniac</html>"
        },
        {
            "<html>26; Stop, then edge into traffic</html>",
            "<html>26; Slow down then proceed with caution</html>",
            "<html>26CORRECT; Come to a complete stop and wait until the way is clear</html>",
            "<html>26; Slow down and signal</html>"
        },
        {
            "<html>27CORRECT; Turn your front wheels towards the curb or right shoulder</html>",
            "<html>27; Leave your front wheels parallel to the curb</html>",
            "<html>27; Turn your front wheels to the left and set your parking brake</html>",
            "<html>27; Set your parking brake only</html>"
        },
        {
            "<html>28CORRECT; Gear down and use the motor to assist in braking</html>",
            "<html>28; Place the gear shift in neutral</html>",
            "<html>28; Turn off the ignition</html>",
            "<html>28; Disengage the clutch and coast</html>"
        },
        {
            "<html>29; Signal and pull from the curb</html>",
            "<html>29; Sound your horn and pull from the curb slowly</html>",
            "<html>29; Check other traffic, signal and pull from the curb quickly</html>",
            "<html>29CORRECT; Always signal and check for traffic, pulling out only when it is safe to do so</html>"
        },
        {
            "<html>30; Have your vehicle taken away for up to three months</html>",
            "<html>30; You can be fined $5000 to $25,000</html>",
            "<html>30CORRECT; All of these</html>",
            "<html>30; You may lose your driver's licence for up to one year</html>"
        },
        {
            "<html>31; A designated parking space to be used by any vehicle showing the permit</html>",
            "<html>31; The holder to park anywhere</html>",
            "<html>31; The holder’s family members to use designated spaces</html>",
            "<html>31CORRECT; A vehicle carrying the person to whom it was issued to use a designated disabled parking space</html>"
        },
        {
            "<html>32; Immediately leave the vehicle to look for help</html>",
            "<html>32; Run the engine continuously to keep the interior of the vehicle as warm as possible</html>",
            "<html>32; Any of these</html>",
            "<html>32CORRECT; Run your vehicle engine for approximately 5 minutes every hour for heating</html>"
        },
        {
            "<html>33; Signal and stop at the nearest parking lot</html>",
            "<html>33CORRECT; Pull over as far to the right as you safely can and come to a complete stop</html>",
            "<html>33; Slow down and stop in the lane you are in</html>",
            "<html>33; Pull over as far to the left as possible</html>"
        },
        {
            "<html>34; Reduce speed</html>",
            "<html>34CORRECT; Stop for a short rest in a safe area</html>",
            "<html>34; Open a window</html>",
            "<html>34; Turn up your radio</html>"
        },
        {
            "<html>35; 11</html>",
            "<html>35; 3</html>",
            "<html>35CORRECT; 7</html>",
            "<html>35; 9</html>"
        },
        {
            "<html>36CORRECT; If you are behind it and it has red lights flashing</html>",
            "<html>36; Any time it is stopped</html>",
            "<html>36; If you are approaching it</html>",
            "<html>36; At no time</html>"
        },
        {
            "<html>37; 90 days</html>",
            "<html>37; 60 days</html>",
            "<html>37CORRECT; 30 days</html>",
            "<html>37; 120 days</html>"
        },
        {
            "<html>38; Lack of skill and control</html>",
            "<html>38; Difficulty obeying traffic laws</html>",
            "<html>38; Unsafe actions</html>",
            "<html>38CORRECT; Any/All of the above</html>"
        },
        {
            "<html>39CORRECT; At least two people</html>",
            "<html>39; At least five people</html>",
            "<html>39; At least three people</html>",
            "<html>39; At least four people</html>"
        },
        {
            "<html>40; Centre of the road</html>",
            "<html>40; Left side</html>",
            "<html>40; Right side</html>",
            "<html>40CORRECT; Side that has the flat tire</html>"
        },
        {
            "<html>41; 10 days</html>",
            "<html>41CORRECT; 90 days</html>",
            "<html>41; 30 days</html>",
            "<html>41; 3 days</html>"
        },
        {
            "<html>42; Only applicable to large vehicles</html>",
            "<html>42; Only applicable to site traffic</html>",
            "<html>42; Optional</html>",
            "<html>42CORRECT; Legally enforceable</html>"
        },
        {
            "<html>43; Accelerate hard to clear the ice</html>",
            "<html>43; Ease off the accelerator and steer immediately to side of the road</html>",
            "<html>43; Brake hard while gripping the steering wheel tightly</html>",
            "<html>43CORRECT; Calmly remove your foot from the accelerator and steer in the direction you want to go</html>"
        },
        {
            "<html>44CORRECT; If a vehicle turning left and only if the shoulder is paved</html>",
            "<html>44; Only if a vehicle is turning left and you have an unpaved shoulder on the right</html>",
            "<html>44; Never</html>",
            "<html>44; Whenever you can do so safely</html>"
        },
        {
            "<html>45; 3 years</html>",
            "<html>45CORRECT; 2 years</html>",
            "<html>45; 4 years</html>",
            "<html>45; 5 years</html>"
        },
        {
            "<html>46; Some drivers unlawfully drive with parking lights only</html>",
            "<html>46; Your reaction time is slower at night</html>",
            "<html>46CORRECT; You cannot see as far ahead, even with headlights</html>",
            "<html>46; The roadways are more apt to be slippery at night</html>"
        },
        {
            "<html>47; In any of these ways</html>",
            "<html>47; Faster</html>",
            "<html>47CORRECT; Slower</html>",
            "<html>47; As if conditions were perfect</html>"
        },
        {
            "<html>48CORRECT; Yield right-of-way to all vehicles approaching on the highway</html>",
            "<html>48; Give a hand signal then take right-of-way</html>",
            "<html>48; Sound the horn and proceed with caution</html>",
            "<html>48; Enter or cross the highway as quickly as possible</html>"
        },
        {
            "<html>49; Only if passengers are over sixteen years of age</html>",
            "<html>49; Only if passengers are over eighteen years of age</html>",
            "<html>49CORRECT; Only if passengers are from five years of age up to sixteen</html>",
            "<html>49; Only if the passengers are in the front seat</html>"
        },
        {
            "<html>50; 125 metres</html>",
            "<html>50CORRECT; 150 metres</html>",
            "<html>50; 250 metres</html>",
            "<html>50; 50 metres</html>"
        },
        {
            "<html>51; Your licence may be suspended for up to two years</html>",
            "<html>51CORRECT; All Of These</html>",
            "<html>51; Can be fined up to $2,000 and sentenced to up to six months in jail</html>",
            "<html>51; Six demerit points</html>"
        },
        {
            "<html>52; Your license will be suspended immediately for 10 days</html>",
            "<html>52; Your license will be suspended immediately for 120 days</html>",
            "<html>52CORRECT; Your license will be suspended immediately for 90 days</html>",
            "<html>52; Your license will be suspended immediately for 30 days</html>"
        },
        {
            "<html>53; Pets</html>",
            "<html>53; Flammable materials</html>",
            "<html>53; Firearms</html>",
            "<html>53CORRECT; Persons</html>"
        },
        {
            "<html>54; Get out and try to wave highway traffic around your vehicle</html>",
            "<html>54CORRECT; Pull over, activate your emergency flashers and wait for help</html>",
            "<html>54; Get out and walk to get help</html>",
            "<html>54; Blow your horn for help</html>"
        },
        {
            "<html>55; Within 1 KM of an oncoming vehicle</html>",
            "<html>55; Within 300m of an oncoming vehicle</html>",
            "<html>55CORRECT; Within 150 metres of an oncoming vehicle</html>",
            "<html>55; There is no set requirement</html>"
        },
        {
            "<html>56; Within 28 days</html>",
            "<html>56; At any time prior to the license renewal date</html>",
            "<html>56CORRECT; Within 6 days</html>",
            "<html>56; Within 12 days</html>"
        },
        {
            "<html>57CORRECT; Pull as far as possible to the right and stop</html>",
            "<html>57; Speed up and get out of the way</html>",
            "<html>57; Signal the driver to pass</html>",
            "<html>57; Continue at same speed</html>"
        },
        {
            "<html>58; Stop, and then enter traffic slowly</html>",
            "<html>58CORRECT; Slow down, stop if necessary and proceed only when the way is clear</html>",
            "<html>58; Stop, and then enter traffic quickly</html>",
            "<html>58; Speed up and force your way into traffic</html>"
        },
        {
            "<html>59CORRECT; Facing traffic</html>",
            "<html>59; Down the centreline</html>",
            "<html>59; With their back to traffic</html>",
            "<html>59; Well out into the traffic lane</html>"
        },
        {
            "<html>60CORRECT; A full lane</html>",
            "<html>60; Half a lane</html>",
            "<html>60; A quarter of a lane</html>",
            "<html>60; Two thirds of a lane</html>"
        }
    };

    static String[][] signAnswers = {
        {
            "<html>1; Local traffic only</html>",
            "<html>1; Traffic circle ahead</html>",
            "<html>1CORRECT; Railway crossing</html>",
            "<html>1; Do not enter</html>"
        },
        {
            "<html>2; Construction zone ahead, slow down</html>",
            "<html>2; River ahead</html>",
            "<html>2CORRECT; Bump or uneven pavement on the road ahead</html>",
            "<html>2; Bridge or Viaduct ahead</html>"
        },
        {
            "<html>3; Construction zone ahead</html>",
            "<html>3CORRECT; Watch for fallen rock and be prepared to avoid a collision</html>",
            "<html>3; Steep hill ahead, be prepared to use a lower gear if necessary</html>",
            "<html>3; Road closed ahead due to fallen rocks</html>"
        },
        {
            "<html>4CORRECT; Driver in this lane must turn right</html>",
            "<html>4; Danger ahead</html>",
            "<html>4; Veer to the right</html>",
            "<html>4; No parking from arrows to corner</html>"
        },
        {
            "<html>5CORRECT; Do not enter this road</html>",
            "<html>5; Keep left</html>",
            "<html>5; Railway crossing</html>",
            "<html>5; Do not pass</html>"
        },
        {
            "<html>6; Maximum speed of 50 km/hour from traffic signal ahead</html>",
            "<html>6; Speed limit for rural school zones</html>",
            "<html>6; End of 50 km/h zone</html>",
            "<html>6CORRECT; Speed limit changes ahead</html>"
        },
        {
            "<html>7; Right turn only at the intersection</html>",
            "<html>7CORRECT; Do not turn left at the intersection</html>",
            "<html>7; Traffic island ahead</html>",
            "<html>7; Hidden intersection ahead</html>"
        },
        {
            "<html>8; Narrow road ahead</html>",
            "<html>8; Hidden intersection ahead</html>",
            "<html>8CORRECT; Winding road ahead</html>",
            "<html>8; Road slippery when wet</html>"
        },
        {
            "<html>9; Traffic circle ahead</html>",
            "<html>9CORRECT; Prohibited sign</html>",
            "<html>9; Roundabout ahead</html>",
            "<html>9; Do not enter roadway</html>"
        },
        {
            "<html>10; Road under construction</html>",
            "<html>10; Narrow bridge ahead</html>",
            "<html>10; Divided highway ends</html>",
            "<html>10CORRECT; Divided highway begins</html>"
        },
        {
            "<html>11; Watch for pedestrians</html>",
            "<html>11CORRECT; You are coming to a school zone</html>",
            "<html>11; You are entering a playground zone</html>",
            "<html>11; You are entering a playground area</html>"
        },
        {
            "<html>12; Stop sign ahead</html>",
            "<html>12; Dead-end street ahead</html>",
            "<html>12CORRECT; Slow-moving vehicle(travelling less than 40km/h)</html>",
            "<html>12; Yield right-of-way to vehicle ahead</html>"
        },
        {
            "<html>13; Sharp bend in the road</html>",
            "<html>13; Railway crossing</html>",
            "<html>13; Pavement ends</html>",
            "<html>13CORRECT; Narrow bridge ahead</html>"
        },
        {
            "<html>14; Crosswalk ahead</html>",
            "<html>14; Winding road ahead</html>",
            "<html>14CORRECT; Sharp curves in the road</html>",
            "<html>14; Exit to the right</html>"
        },
        {
            "<html>15CORRECT; Pavement narrows ahead</html>",
            "<html>15; One-way street ahead</html>",
            "<html>15; Hidden intersection ahead</html>",
            "<html>15; Divided highway ahead</html>"
        },
        {
            "<html>16; Bump 150 meters ahead</html>",
            "<html>16CORRECT; You must come to a complete stop and do not proceed until safe</html>",
            "<html>16; Stop only if other vehicles are approaching</html>",
            "<html>16; Stop 150 meters ahead</html>"
        },
        {
            "<html>17CORRECT; Permissive sign</html>",
            "<html>17; Do not enter</html>",
            "<html>17; Roundabout ahead</html>",
            "<html>17; Route for large trucks</html>"
        },
        {
            "<html>18; Oncoming traffic must stop</html>",
            "<html>18; Railway crossing ahead</html>",
            "<html>18CORRECT; Yield the right of way</html>",
            "<html>18; School zone ahead</html>"
        },
        {
            "<html>19; Free flow</html>",
            "<html>19; Winding road ahead</html>",
            "<html>19; Sharp turn or bend in the road</html>",
            "<html>19CORRECT; Sharp turn or bend in the road in the direction of the arrow</html>"
        },
        {
            "<html>20; Road slippery when wet</html>",
            "<html>20CORRECT; Do not turn to go in the opposite direction. (U-turn)</html>",
            "<html>20; Left turn prohibited</html>",
            "<html>20; Right turn prohibited</html>"
        },
        {
            "<html>21CORRECT; Railway crossing ahead</html>",
            "<html>21; Hospital zone ahead, yield to oncoming traffic</html>",
            "<html>21; 4-way intersection ahead, through traffic may proceed</html>",
            "<html>21; Pedestrian crosswalk ahead, yield to pedestrians</html>"
        },
        {
            "<html>22; Pass other traffic on the right</html>",
            "<html>22; Winding road ahead</html>",
            "<html>22; Road turns right, then left</html>",
            "<html>22CORRECT; Keep to the right of the traffic island</html>"
        },
        {
            "<html>23; School area ahead</html>",
            "<html>23; Flagman on duty ahead</html>",
            "<html>23CORRECT; Road work ahead</html>",
            "<html>23; Pedestrian control sign</html>"
        },
        {
            "<html>24; Steep hill ahead</html>",
            "<html>24CORRECT; Right lane ends ahead</html>",
            "<html>24; Pedestrian crossing ahead</html>",
            "<html>24; Hidden intersection ahead</html>"
        },
        {
            "<html>25CORRECT; Warn of a school crossing</html>",
            "<html>25; Playground area sign</html>",
            "<html>25; Direction sign for children</html>",
            "<html>25; Children playing in residential area</html>"
        },
        {
            "<html>26; Road forks to the right.</html>",
            "<html>26; The lane is only for two-way left turns.</html>",
            "<html>26CORRECT; Keep to the right lane except when passing on two-lane sections where climbing or passing lanes are provided</html>",
            "<html>26; This is a pedestrian crossover</html>"
        },
        {
            "<html>27; Bridge Ahead</html>",
            "<html>27; Narrow road ahead</html>",
            "<html>27CORRECT; Paved surface ends ahead</html>",
            "<html>27; Intersection ahead</html>"
        },
        {
            "<html>28; Wildlife preservation center ahead</html>",
            "<html>28CORRECT; Deer regularly cross this road</html>",
            "<html>28; Scenic view ahead</html>",
            "<html>28; Zoo ahead</html>"
        },
        {
            "<html>29; Slow moving vehicle ahead</html>",
            "<html>29; Yield right-of-way</html>",
            "<html>29; Dead end street ahead</html>",
            "<html>29CORRECT; Stop sign ahead. Slow down</html>"
        },
        {
            "<html>30; One-way road only</html>",
            "<html>30CORRECT; Do not pass on this road</html>",
            "<html>30; Do not enter ahead</html>",
            "<html>30; No parking ahead</html>"
        },
        {
            "<html>31; Snowmobile parking ahead</html>",
            "<html>31; Bicycle parking permitted</html>",
            "<html>31CORRECT; Snowmobiles cross this road</html>",
            "<html>31; Caution, Animal Crossing</html>"
        },
        {
            "<html>32CORRECT; Do not drive through the intersection</html>",
            "<html>32; Through traffic permitted</html>",
            "<html>32; You may proceed through intersection, if clear</html>",
            "<html>32; Traffic signal ahead</html>"
        },
        {
            "<html>33; Right turn allowed</html>",
            "<html>33; Right turn only</html>",
            "<html>33CORRECT; Slight bend or curve in the road ahead</html>",
            "<html>33; Winding road ahead</html>"
        },
        {
            "<html>34; Bicycle shop ahead</html>",
            "<html>34CORRECT; This road is an official bicycle route</html>",
            "<html>34; Biking is not allowed</html>",
            "<html>34; Bicycle parking</html>"
        },
        {
            "<html>35; Obstruction ahead</html>",
            "<html>35; One way traffic</html>",
            "<html>35CORRECT; Intersection ahead</html>",
            "<html>35; Two-way traffic</html>"
        },
        {
            "<html>36CORRECT; Traffic may travel in one direction only</html>",
            "<html>36; Do not turn right</html>",
            "<html>36; One-way traffic ends</html>",
            "<html>36; Two-way traffic ahead</html>"
        },
        {
            "<html>37; Park in the area between the signs</html>",
            "<html>37; Restricted parking available</html>",
            "<html>37CORRECT; Do not park in the area between the signs</html>",
            "<html>37; Free parking available</html>"
        },
        {
            "<html>38; Scool bus entrance ahead</html>",
            "<html>38CORRECT; Fire truck entrance ahead</html>",
            "<html>38; Large truck entrance ahead</html>",
            "<html>38; Bus entrance ahead</html>"
        },
        {
            "<html>39CORRECT; Truck entrance on the right side of the road ahead</html>",
            "<html>39; Underpass ahead, Take care if you are driving a tall vehicle</html>",
            "<html>39; Hidden school bus stop</html>",
            "<html>39; Truck entrance on the left side of the road ahead</html>"
        },
        {
            "<html>40CORRECT; There may be water flowing over the road</html>",
            "<html>40; River ahead</html>",
            "<html>40; Pavement is slippery when wet</html>",
            "<html>40; Bump or uneven pavement</html>"
        },
        {
            "<html>41; The lane is only for right turns</html>",
            "<html>41; Yield the lane to oncoming traffic</html>",
            "<html>41CORRECT; The lane is only for two-way left turns</html>",
            "<html>41; Two-way traffic ahead</html>"
        },
        {
            "<html>42; Motorcycle crossing ahead</html>",
            "<html>42; Bicycles not permitted</html>",
            "<html>42CORRECT; Bicycle crossing ahead</html>",
            "<html>42; Bicycle parking permitted</html>"
        },
        {
            "<html>43; School bus stop ahead</html>",
            "<html>43CORRECT; Warns motorists to provide safe space on the road for cyclists</html>",
            "<html>43; Lane is too narrow for side-by-side driving</html>",
            "<html>43; Bicycle crossing</html>"
        },
        {
            "<html>44CORRECT; Do not turn right when facing a red light at the intersection</html>",
            "<html>44; Do not turn right</html>",
            "<html>44; Only right turn allowed</html>",
            "<html>44; Do not turn left</html>"
        },
        {
            "<html>45; Minimum speed</html>",
            "<html>45; Maximum speed</html>",
            "<html>45; Traffic signal ahead</html>",
            "<html>45CORRECT; Underpass ahead</html>"
        },
        {
            "<html>46; Trans-Canada highway</html>",
            "<html>46CORRECT; Off-road facilities, Hospital</html>",
            "<html>46; Off-road facilities, Hiking</html>",
            "<html>46; Recreation area ahead</html>"
        },
        {
            "<html>47; Road under construction</html>",
            "<html>47CORRECT; Divided highway ends</html>",
            "<html>47; Divided highway ahead</html>",
            "<html>47; Narrow bridge ahead</html>"
        },
        {
            "<html>48CORRECT; No pedestrians allowed on this road</html>",
            "<html>48; Pedestrians permitted</html>",
            "<html>48; Drivers are not permitted to hit pedestrians on this road</html>",
            "<html>48; Crosswalk, watch for pedestrians</html>",
        },
        {
            "<html>49; Railway crossing ahead</html>",
            "<html>49; Traffic control signals ahead</html>",
            "<html>49; Pedestrian crossing</html>",
            "<html>49CORRECT; Hidden school bus stop ahead</html>"
        },
        {
            "<html>50; Right turn only</html>",
            "<html>50CORRECT; Flashing lights on the arrows show the direction to follow</html>",
            "<html>50; Left turn only</html>",
            "<html>50; Do not turn right</html>"
        },
        {
            "<html>51; You may exit if you remain in right-hand lane</html>",
            "<html>51; Sharp curves in the road</html>",
            "<html>51CORRECT; Roundabout ahead</html>",
            "<html>51; Hazard close to the edge of the road</html>"
        },
        {
            "<html>52CORRECT; Hazard close to the edge of the road</html>",
            "<html>52; Paved surface ends ahead</html>",
            "<html>52; Do not enter</html>",
            "<html>52; Right lane ends ahead</html>"
        },
        {
            "<html>53; Pedestrians not permitted</html>",
            "<html>53; School zone ahead, watch for children crossing, obey any crossing guards on duty</html>",
            "<html>53CORRECT; Watch for pedestrians and be prepared to share the road with them</html>",
            "<html>53; Pedestrian pathway only, vehicles prohibited</html>"
        },
        {
            "<html>54; Bicycle parking permitted here</html>",
            "<html>54; Bicycle parking not permitted on this road</html>",
            "<html>54CORRECT; No bicycles allowed on this road</html>",
            "<html>54; Motorcycles not permitted on this road</html>"
        },
        {
            "<html>55; X intersection for school vehicles</html>",
            "<html>55CORRECT; Slow traffic on multi-lane roads must keep right</html>",
            "<html>55; Caution school bus crossing</html>",
            "<html>55; School crosswalk sign</html>"
        },
        {
            "<html>56; Safety check ahead</html>",
            "<html>56CORRECT; Steep hill ahead. You may need to use a lower gear</html>",
            "<html>56; Pavement ends 12 feet ahead</html>",
            "<html>56; Bumpy road ahead</html>"
        },
        {
            "<html>57; Bumpy road ahead</html>",
            "<html>57; Winding road ahead</html>",
            "<html>57; Sharp bend in the road</html>",
            "<html>57CORRECT; Pavement is slippery when wet</html>"
        },
        {
            "<html>58; Provincial park notification</html>",
            "<html>58CORRECT; Destination sign</html>",
            "<html>58; Pedestrian control sign</html>",
            "<html>58; Recreation area ahead</html>"
        },
        {
            "<html>59CORRECT; Traffic lights ahead. Slow down</html>",
            "<html>59; Stop 150 meters ahead</html>",
            "<html>59; Bump 120 meters ahead</html>",
            "<html>59; School bus stop ahead</html>"
        },
        {
            "<html>60; There are no stop signs in the direction of the arrows, proceed with caution</html>",
            "<html>60; Approaching vehicles must stop, then may proceed with caution</html>",
            "<html>60CORRECT; Do not stop in the area between the signs</html>",
            "<html>60; No entry into intersection</html>"
        }
    };

    public static void main(String[] args) {
        gameFrame = new JFrame("G1 Program");
        gameFrame.setSize(800, 710);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);

        panelReset(2);

        gameFrame.setVisible(true);
        gameFrame.setResizable(false);

        gameMode = 0;

        mainMenu();
    }

    public static void mainMenu() {
        buttonArray = new JButton[3];

        buttonArray[0] = new JButton("Knowledge Test");
        buttonArray[1] = new JButton("Signs Test");
        buttonArray[2] = new JButton("Marathon");

        try {                
            backgroundImage = ImageIO.read(new File("Background.jpg"));
        } catch (IOException ex){} 
        
        buttonsToCanvas(gameMode);

        buttonArray[0].setBounds(300, 300, 200, 100);
        buttonArray[1].setBounds(300, 410, 200, 100);
        buttonArray[2].setBounds(300, 520, 200, 100);
        

        answeredCorrect = 0;
        questionKnowledgeCounter = 0;
        questionSignsCounter = 0;


        gameFrame.repaint();
    }

    public static void knowledge() {
        int questionInstance;
        int questionIndex;
        String question;
        String[] randAnswers = new String[4];
        Border border;
        Border margin = new EmptyBorder(0, 50, 0, 50);

        northCanvas.removeAll();
        buttonArray = new JButton[5];

        do {
            questionInstance = 0;
            questionIndex = (int) ((questionRange - 0 + 1) * Math.random() + 0);

            for (int i = 0; i < usedQuestionsKnowledge.length; i++) {
                if (usedQuestionsKnowledge[i] == questionIndex){
                    questionInstance++;
                }
            }
        } while (questionInstance > 0);

        questionKnowledgeCounter++;

        usedQuestionsKnowledge[questionKnowledgeCounter - 1] = questionIndex;

        question = "<html>" + knowledgeQuestions[questionIndex].substring((knowledgeQuestions[questionIndex].indexOf(":") + 2));
        questionDisplay = new JLabel(question, SwingConstants.CENTER);
        border = BorderFactory.createLineBorder(lightBlue, 5);
        questionDisplay.setBorder(new CompoundBorder(border, margin));
        northCanvas.add(questionDisplay);

        for (int i = 0; i < 4; i++){
            randAnswers[i] = knowledgeAnswers[questionIndex][i];
        }

        answersRandomized(randAnswers);

        counterLabel((questionSignsCounter + questionKnowledgeCounter), usedQuestionsKnowledge.length, gameMode);

        buttonArray[4] = new JButton("Exit");

        buttonsToCanvas(gameMode);

        questionDisplay.setBounds(10, 10, 780, 270);
        buttonArray[4].setBounds(720, 10, 70, 50);
        buttonArray[0].setBounds(10, 70, 385, 150);
        buttonArray[1].setBounds(405, 70, 385, 150);
        buttonArray[2].setBounds(10, 230, 385, 150);
        buttonArray[3].setBounds(405, 230, 385, 150);

        gameFrame.repaint();
    }

    public static void signs() {
        int questionInstance;
        int questionIndex;       
        String[] randAnswers = new String[4];

        buttonArray = new JButton[5];

        do {
            questionInstance = 0;
            questionIndex = (int) ((questionRange - 0 + 1) * Math.random() + 0);

            for (int i = 0; i < usedQuestionsSigns.length; i++) {
                if (usedQuestionsSigns[i] == questionIndex){
                    questionInstance++;
                }
           }
        } while (questionInstance > 0);

        questionSignsCounter++;

        usedQuestionsSigns[questionSignsCounter - 1] = questionIndex;

        try {                
            imageQuestion = ImageIO.read(new File((String.valueOf(questionIndex) + ".jpg")));
        } catch (IOException ex){} 

        imageHeight = imageQuestion.getHeight();
        imageWidth = imageQuestion.getWidth();

        JLabel picLabel = new JLabel(new ImageIcon(imageQuestion));
        northCanvas.add(picLabel);

        for (int i = 0; i < 4; i++){
            randAnswers[i] = signAnswers[questionIndex][i];
        }

        answersRandomized(randAnswers);

        counterLabel((questionSignsCounter + questionKnowledgeCounter), usedQuestionsSigns.length, gameMode);

        for (int i = 0; i < randAnswers.length; i++){
            buttonArray[i] = new JButton(randAnswers[i]);
        }

        buttonArray[4] = new JButton("Exit");

        buttonsToCanvas(gameMode);

        buttonArray[4].setBounds(720, 10, 70, 50);
        buttonArray[0].setBounds(10, 70, 385, 150);
        buttonArray[1].setBounds(405, 70, 385, 150);
        buttonArray[2].setBounds(10, 230, 385, 150);
        buttonArray[3].setBounds(405, 230, 385, 150);

        gameFrame.repaint();
    }

    public static void marathon(){
        int randSection;

        panelReset(1);

        if (questionSignsCounter == 59) {
            randSection = 1;
        } else if (questionKnowledgeCounter == 59){
            randSection = 2;
        } else {
            randSection = (int) ((2 - 1 + 1) * Math.random() + 1);
        }

        panelReset(1);

        if (randSection == 1){
            gameMode = 3;
            knowledge();
        }

        else if (randSection == 2){
            gameMode = 4;
            signs();
        }
    }

    public static void endScreen(){
        Border border;

        buttonArray = new JButton[1];

        buttonArray[0] = new JButton("Main Menu");

        if (gameMode == 1 || gameMode == 2) {
            if (answeredCorrect > 15){
                endResults = new JLabel(("<html>You have passed the test with the score of " + ((answeredCorrect + " / " + (questionKnowledgeCounter + questionSignsCounter))) + ". Well Done!</html>"), SwingConstants.CENTER);
                border = BorderFactory.createLineBorder(myGreen, 5);
            } else{
                endResults = new JLabel(("<html>You have failed the test with the score of " + ((answeredCorrect + " / " + (questionKnowledgeCounter + questionSignsCounter))) + ". Try again.</html>"), SwingConstants.CENTER);
                border = BorderFactory.createLineBorder(myRed, 5);
            }
        } else if (gameMode == 3 || gameMode == 4) {
            endResults = new JLabel(("<html>Questions Correct: " + answeredCorrect + " | Total Questions: " + (questionKnowledgeCounter + questionSignsCounter) + "</html>"), SwingConstants.CENTER);
            border = BorderFactory.createLineBorder(lightBlue, 5);
        } else {
            System.out.println(gameMode);
            endResults = new JLabel(("<html>Not Supposed to Happen...</html>"), SwingConstants.CENTER);
            border = BorderFactory.createLineBorder(Color.GREEN, 5);
        }

        System.out.println("Game Mode " + gameMode);

        gameMode = 5;

        try {                
            backgroundImage = ImageIO.read(new File("Background1.jpg"));
        } catch (IOException ex){} 

        Border margin = new EmptyBorder(0, 10, 0, 10);
        
        endResults.setBorder(new CompoundBorder(border, margin));

        centerCanvas.add(endResults);
        
        buttonsToCanvas(gameMode);

        endResults.setBounds(200, 200, 400, 50);
        buttonArray[0].setBounds(350, 500, 100, 50);

        gameFrame.repaint();
    }

    public static void decisionStructure(int gameMode){
        centerCanvas.removeAll();
        if (gameMode == 1){
            if (questionKnowledgeCounter == 20){
                panelReset(2);
                endMenu = true;
                endScreen();
            } else{
                knowledge(); 
            }
        } else if (gameMode == 2){
            if (questionSignsCounter == 20){
                panelReset(2);
                endMenu = true;
                endScreen();
            } else{
                signs(); 
            }
        } else if (gameMode == 3 || gameMode == 4){
            if ((questionSignsCounter + questionKnowledgeCounter) == 100){
                panelReset(2);
                endMenu = true;
                endScreen();
            } else{
                marathon(); 
            }
        }
    }

    public static void panelReset(int setting){
        gameFrame.getContentPane().removeAll();
        gameFrame.repaint();

        if (setting == 1) {  
            northCanvas = new GraphicsPanelOne();
            northCanvas.setPreferredSize(new Dimension(800, 280));
            northCanvas.setLayout(null);
            // northCanvas.setBackground(Color.BLUE);
            gameFrame.add(northCanvas, BorderLayout.NORTH);

            southCanvas = new GraphicsPanelThree();
            southCanvas.setPreferredSize(new Dimension(800, 10));
            southCanvas.setLayout(null);
            gameFrame.add(southCanvas, BorderLayout.SOUTH);
            // southCanvas.setBackground(Color.GREEN);
        }

        centerCanvas = new GraphicsPanelTwo();
        centerCanvas.setMaximumSize(new Dimension(800, 620));
        centerCanvas.setLayout(null);
        gameFrame.add(centerCanvas, BorderLayout.CENTER);

        gameFrame.repaint();
        gameFrame.setVisible(true);
    }

    public static void counterLabel(int answered, int total, int gameMode){
        if (gameMode == 3 || gameMode == 4){
            total += 40;
        }
        progress = new JLabel((answered + " / " + total), SwingConstants.CENTER);
        centerCanvas.add(progress);

        progress.setBounds(10, 10, 70, 50);
    }

    public static void buttonsToCanvas(int window){
        for (int i = 0; i < buttonArray.length; i++){
            centerCanvas.add(buttonArray[i]);
            if (window == 0) {
                buttonArray[i].addActionListener(new menuActionListener());
            } else if (window == 5) {
                buttonArray[i].addActionListener(new endActionListener());
            }  else {
                buttonArray[i].addActionListener(new gameActionListener());
            }
        }
    }

    public static void answersRandomized(String[] randAnswers){
        String temp;
        int randIndex;
        String revisedAnswer;

        for (int i = 0; i < randAnswers.length; i++){
            if (randAnswers[i].contains("CORRECT")){
                correctButton = i + 1;
                System.out.println(randAnswers[i]);
            }
            revisedAnswer = "<html>" + randAnswers[i].substring((randAnswers[i].indexOf(";") + 2));
            randAnswers[i] = revisedAnswer;
        }

        for (int i = 0; i < randAnswers.length; i++){
            buttonArray[i] = new JButton(randAnswers[i]);
        }
    }

    //----------------------------------------------------------------------

    static class GraphicsPanelOne extends JPanel {
        public GraphicsPanelOne() {
            setFocusable(true);
            requestFocusInWindow();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (gameMode == 2 || gameMode == 4) {
                g.drawImage(imageQuestion, 400 - (imageWidth/2), 140 - (imageHeight/2), this);
            } 

            northCanvas.repaint();
        }
    }

    static class GraphicsPanelTwo extends JPanel {
        public GraphicsPanelTwo() {
            setFocusable(true);
            requestFocusInWindow();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            JLabel credits = new JLabel("By: Amun & Daniel");
            Font font = new Font("JetBrains Mono", Font.BOLD, 40);

            centerCanvas.add(credits);

            if (gameMode == 0) {
                g.setFont(font);
                g.drawImage(backgroundImage, 0, -100, centerCanvas);
                g.drawString("G1 Practice Test", 225, 100);
                credits.setBounds(15, 610, 150, 100);


            } else if (gameMode == 5) {
                g.drawImage(backgroundImage, -500, -250, centerCanvas);

                int index = 0;
                int incrementsX = 0;
                int incrementsY = 0;
                int sizeX = 0;
                int sizeY = 0;
                int startPoint = 0;

                if (answeredDisplay.length() == 20) {
                    incrementsX = 80;
                    incrementsY = 40;
                    sizeX = 6;
                    sizeY = 5;
                    startPoint = 120;

                } else if (answeredDisplay.length() == 100) {
                    incrementsX = 48;
                    incrementsY = 20;
                    sizeX = 10;
                    sizeY = 10;
                    startPoint = 136;
                }

                for (int yValue = 1; yValue < sizeY; yValue++) {
                    for (int xValue = 1; xValue < sizeX; xValue++) {
                        if (answeredDisplay.charAt(index) == 'c') {
                            g.setColor(myGreen);
                        }
                        else if (answeredDisplay.charAt(index) == 'n'){
                            g.setColor(myRed);
                        }

                        g.fillRect(startPoint + incrementsX * xValue, 250 + incrementsY * yValue, incrementsX, incrementsY);

                        g.setColor(outlineColor);
                        g.drawLine(startPoint + incrementsX * xValue, 250 + incrementsY * yValue, startPoint + incrementsX + incrementsX * xValue, 250 + incrementsY * yValue);
                        g.drawLine(startPoint + incrementsX * xValue, 250 + incrementsY * (yValue + 1), startPoint + incrementsX + incrementsX * xValue, 250 + incrementsY * (yValue + 1));

                        g.drawLine(startPoint + incrementsX * xValue, 250 + incrementsY * yValue, startPoint + incrementsX * xValue, 250 + incrementsY + incrementsY * yValue);
                        g.drawLine(startPoint + incrementsX * (xValue + 1), 250 + incrementsY * yValue, startPoint + incrementsX * (xValue + 1), 250 + incrementsY + incrementsY * yValue);

                        index++;
                    }
                }
            }

            centerCanvas.repaint();
        }
    }

    static class GraphicsPanelThree extends JPanel {
        public GraphicsPanelThree() {
            setFocusable(true);
            requestFocusInWindow();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            int questionAmount;

            if (gameMode == 3 || gameMode == 4) {
                questionAmount = 100;
            } else {
                questionAmount = 20;
            }
 
            int increments = (800/questionAmount);

            for (int i = 0; i < answeredDisplay.length(); i++){
                if (answeredDisplay.charAt(i) == 'c') {
                    g.setColor(myGreen);
                    g.fillRect(increments * i, 0, increments, 10);
                } else if (answeredDisplay.charAt(i) == 'n') {
                    g.setColor(myRed);
                    g.fillRect(increments * i, 0, increments, 10);
                }
            }

            // g.setColor(outlineColor);

            // for (int i = 0; i < answeredDisplay.length(); i++){
            //     g.drawLine(increments * i, 0, increments * (i+1), 0);
            //     g.drawLine(increments * (i+1), 0, increments * (i+1), 10);
            // }

            // g.setColor(Color.GREEN);
            // g.fillRect(0, 0, (800/questionAmount) * (questionSignsCounter + questionKnowledgeCounter - 1), 10);

            southCanvas.repaint();
        }
    }

    static class menuActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (buttonArray[0] == event.getSource()){
                panelReset(1);

                questionKnowledgeCounter = 0;
                usedQuestionsKnowledge = new int[20];
                gameMode = 1;
                
                gameFrame.setVisible(true);
                answeredDisplay = "";

                knowledge();
            } else if (buttonArray[1] == event.getSource()) {
                panelReset(1);

                questionSignsCounter = 0;
                usedQuestionsSigns = new int[20];
                gameMode = 2;

                centerCanvas.setVisible(true);
                answeredDisplay = "";

                signs();
            } else if (buttonArray[2] == event.getSource()) {
                usedQuestionsSigns = new int[60];
                usedQuestionsKnowledge = new int[60];

                questionKnowledgeCounter = 0;
                questionSignsCounter = 0;

                gameFrame.setVisible(true);
                answeredDisplay = "";

                marathon();
            }
        }
    }

    static class gameActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (buttonArray[0] == event.getSource()){
                if (correctButton == 1){
                    answeredCorrect++;
                    answeredDisplay += "c";
                } else {
                    answeredDisplay += "n";
                }

                try {Thread.sleep(500);} catch(Exception e) {}
            
                decisionStructure(gameMode);
            } else if (buttonArray[1] == event.getSource()) {
                if (correctButton == 2){
                    answeredCorrect++;
                    answeredDisplay += "c";
                } else {
                    answeredDisplay += "n";
                }

                try {Thread.sleep(500);} catch(Exception e) {}
            
                decisionStructure(gameMode);
                
            } else if (buttonArray[2] == event.getSource()) {
                if (correctButton == 3){
                    answeredCorrect++;
                    answeredDisplay += "c";
                } else {
                    answeredDisplay += "n";
                }

                try {Thread.sleep(500);} catch(Exception e) {}
            
                decisionStructure(gameMode);
            } else if (buttonArray[3] == event.getSource()) {
                if (correctButton == 4){
                    answeredCorrect++;
                    answeredDisplay += "c";
                } else {
                    answeredDisplay += "n";
                }

                try {Thread.sleep(500);} catch(Exception e) {}
            
                decisionStructure(gameMode);
            } else if (buttonArray[4] == event.getSource()) {
                panelReset(2);

                gameMode = 0;
                mainMenu();
            }
        }
    }

    static class endActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (buttonArray[0] == event.getSource()) {
                panelReset(2);

                gameMode = 0;
                mainMenu();
            }
        }
    }

}
