HearthStats.net Uploader
========================

This is a Java based utility designed to run in the background and automatically
upload your win ratios and other statistics to [HearthStats.net](http://HearthStats.net)
while you play Hearthstone. This program uses screen grab analysis of your Hearthstone window
and does not do any packet sniffing, monitoring, or network modification of any kind.

This project is and always will be open source so that you can do your own builds 
and see exactly what's happening within the program. 

Contributing to this Project
----------------------------

There are several things you can do to help this project out:

* Check out and participate in [the reddit thread](http://www.reddit.com/r/hearthstone/comments/1wa4rc/auto_uploader_for_hearthstatsnet_need_help_testing/)
* Download and test early builds, making sure to [report any issues you find](https://github.com/JeromeDane/HearthStats.net-Uploader/issues)
* Fork this repository if you can hack, and create a pull request if you come up with things to contribute.
* [Buy Jerome a cup of coffee via PayPal](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=F9XNSXLZNP9QQ) for his work on this uploader
* Donate to HearthStats.net's founder Jeff through the site's [about us page](http://hearthstats.net/aboutus) 

Running Alpha Builds
--------------------

This project is under HEAVY construction, but you can still run alpha builds
to help test things out or just see how things are going. Check out the project's
[milestones](https://github.com/JeromeDane/HearthStats.net-Uploader/issues/milestones) 
to see how things are progressing.

* Make sure you have Java installed (use windows (http://java.com/en/download/manual.jsp) builds)
* Download the __[latest release](https://github.com/JeromeDane/HearthStats.net-Uploader/releases)__ of the HearthStats.net Uploader
* Extract the downloaded zip file to any directory
* Log into the [HearthStats.net Beta Site](http://beta.hearthstats.net/)
* If you play constructed, go to Decks > [Active Decks](http://beta.hearthstats.net/decks/active_decks) and set your decks there to match the layout you have in game
* Find your __userkey__ on [your profile page](http://beta.hearthstats.net/profile)
* Edit __config.ini__, replace **your_userkey_here** with the string you found in the previous step, and save the file   
* Run the HearthStatsUploader.jar
* A window should open called "HearthStats.net Uploader"
* Start your Hearthstone client and put it in __windowed mode__ (see [issue #17](https://github.com/JeromeDane/HearthStats.net-Uploader/issues/17))
* Look for notifications in the bottom right of your screen that indicate event detection
* [Report any issues you find](https://github.com/JeromeDane/HearthStats.net-Uploader/issues)

Known Issues
-------------

* Game must be running in __windowed mode__ for now (see [issue #17](https://github.com/JeromeDane/HearthStats.net-Uploader/issues/17))
* Only supports Windows at the moment
* There is currently little configuration interface
* Minimizing Hearthstone completely freezes the uploader (see [issue #67](https://github.com/JeromeDane/HearthStats.net-Uploader/issues/76))
 
Please see the full [list of known issues](https://github.com/JeromeDane/HearthStats.net-Uploader/issues)
as well.