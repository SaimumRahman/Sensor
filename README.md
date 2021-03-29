# Sensor

An application created to retrieve the values generated by various sensors of a mobile phone like Light Sensor.
Proximity Sensor Accelerometer Gyroscope and storing the values on a persistance data storage. 
The values are later projected as list structures and the overall process of data collection and storage is created as a background process.
Android|Java|AndroidRoom|SQLite

#Learnings
As I have never worked with these sensors before I had no idea about how these works. I have learned how to call these sensors and using sensor manager and get values 
from them using sensor event listenner. There are so many many services of android, I saw it while using sensor manager.
And also many different sensor delays normal delay, game delay and many others. But i have only used normal delay as we are getting data 5 minutes interval.
I have also learned the actual full implementation of Android Room, LiveData, ViewModel.

#Challenges

I faced some problems while inserting sensors values into room databse. The problem was main thread the viewmodel class wasn't getting instantiated. 
Then I read ViewModel documentation from android developers portal. Then I learned how to the view model properly in API 29 or above. Because of the methods are depricated.
And while retrieving data from the database I have also faced problems. The problem was the we are recieving are LiveData but the does not support LiveData.
So, for that I created a void method in the adapter class to get all the data in a List form. 

