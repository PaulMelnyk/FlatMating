# FlatMating

This Application is a Venue viewing system, 
Linked to my application for the position of junior application developer with SpareRoom.

I have worked on this around my University shedule, and it is now at a point I am happy to display.
Please note the inclusion of class named 'TESTCaseNewEvents.java', simply used to add future events into my arraylist,
as they are all earlier than current date and so appear in archived. 
This can be removed if desired, by removing line 120 from the 'OnScreenSetters.java'

Features -
  - Selected Button highlighted
  - Expired and Upcoming Events display corresponding Venues, with Upcoming Displaying an 'Expired' tag over the image 
  - Create list ordered on date, closest dates first
  - Click on image will dial phone number associated - Currently pre-set number as Venue API does not include a number 
    (this can be simply changed)
    
Design Choices -
  - I chose to display the upcoming and archived buttons on the bottom of the screen, as this felt more natural.
      This is due to the manner in which users will hold the phone, it is in my opinion more natural
  - I chose to place colour behind text on images. This was to both break up the screen and make text easier to read.
      The colour chosen is a slightly opaque version of the main text colour, keeping the application in tone together.
      
Paul Melnyk
