# SimpleHouseBackend
This is backend demo of a restaurant site. Site template was downloaded from templatemo.com
Author: Jakub Żytkowski

All the java code that is there i wrote myself.

Login site is hidden under /login GET request. 

When you log in you get access to buttons/sites that let you add, delete or modify meals, categories or customer messages.
All of it is secured with Spring Secure.

All the data is stored in MySQL DB, passwords are encrypted and are stored in bcrypt form.
Non Regular exceptions are being logged in exceptionLog.txt

If nobody is logged in you can't access any of the CRUD function sites or forms.
