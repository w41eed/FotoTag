Waleed Ashfaq

App just loads Pictures from a link and displays it in the form of a list.
User can Rate the pics and also filter the pics based on ratings.


Load Button:
-Clicking the Load button loads a set of 10 images with hardcoded links to a URL
-Clears the Ratings for Images But does not reset Filter Bar


Clear Button
-Clears All images and displays a black rectangular border as a place holder and indicator of an empty ImageView
-Clears the ratings when pressed


Filter Bar
-Has the form of a RatingBar and is placed between the Load and Clear Icons.
-User can choose "Rating" as one would for a normal rating bar and the images get filtered out.
-Images with >= filter Bar rating are visible
-Does not clear out when Load and Clear are pressed. Have to manually reset filter to view images


Code For Downloading images from a URL to an ImageView was implemented using help from source:
- https://www.youtube.com/watch?v=Il3uB5u2pSA


Orientation Changes
-Only one XML file for Layout implemented
- When device changes orientation, the images and ratings dissappear but scrolling works and layout is somewhat fine.

Touch to Enarge ImageView has not been implemented


For Load Button Icon
https://www.google.com/search?q=load+icon&safe=strict&rlz=1C1CHBF_enCA746CA746&tbm=isch&source=iu&ictx=1&fir=vAlKDbIWRAMBEM%253A%252CoRpkxYBI_xe7gM%252C_&vet=1&usg=AI4_-kRABsT-Dtbbs4unxpZnCHkrlLiE7A&sa=X&ved=2ahUKEwjcm-yG4JnhAhUp64MKHWHtB5YQ9QEwAHoECAcQBA#imgrc=vAlKDbIWRAMBEM:&vet=1


For Clear Button Icon:
https://www.google.com/search?safe=strict&rlz=1C1CHBF_enCA746CA746&tbm=isch&sa=1&ei=ke6WXO9fivuPBLr4upAC&q=delete+icon&oq=delete+icon&gs_l=img.3...24681.26686..27353...0.0..1.798.1481.5-1j1......1....1..gws-wiz-img.7ryyMeooI2E#imgrc=YLDTcsBBZ2AV4M:


