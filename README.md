# ModificationZXINGBarcodeScanner

Lib modification
This lib works without Zxing Library

Bug Was found at May 2016

--

Google Announcement

There is a service that downloads files required by Mobile Vision to run but is now disabled due to a serious bug discovered late in development. This will prevent users who have not already used Face or Barcode detection from using Face or Barcode scanning. We offer the following advice to Google Play Services developers:

Do not add new Mobile Vision features until this issue is fixed.
For apps that already use Mobile Vision functions, call FaceDetector.isOperational() or BarcodeDetector.isOperational() to check for detector readiness and degrade feature operation accordingly.
We are working to correct the problem as soon as possible. We expect it will take several weeks to test it thoroughly.

