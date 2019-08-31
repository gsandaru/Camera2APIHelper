 # Camera2APIHelper
Camera utility library for Camera2 API - Inspired by various internet sources and Google Documentation.
[![](https://jitpack.io/v/gsandaru/Camera2APIHelper.svg)](https://jitpack.io/#gsandaru/Camera2APIHelper)
[![License](https://camo.githubusercontent.com/5b17d82d9a87c80cdd019bacb35c23f3515d33c3/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4c6963656e73652d417061636865253230322e302d79656c6c6f77677265656e2e737667)](https://opensource.org/licenses/Apache-2.0)  
### Add Dependencies


root gradle

    allprojects {  
        repositories {  
            ...
            maven { url "https://jitpack.io" }  
        }  
    }

application gradle

    dependencies {
            implementation 'com.github.gsandaru:Camera2APIHelper:master-SAPSHOT'
    }

### Usage

* Add Camera permissions to your application
* Add Read External Storage, Write External Storage permissions
* Initialize 

       CameraAPIHelper  cameraAPIHelper = new CameraAPIHelper.Builder(textureView, this)  
            .setCameraType(CameraAPIHelper.CameraType.BACK)  
            .setImageCompressionRatio(80)  
            .setImageWidthandHeight(600, 600)  
            .build();

* <b>Options for Camera Type - FRONT, BACK</b>
### How to take a picture

 

      findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {  
        @Override  
        public void onClick(View view) {  
      
            File saveFile = new File(Environment.getExternalStorageDirectory(), "test.png");  
            
            cameraAPIHelper.takePictureAndSavetoFile(saveFile, new CameraAPIHelper.CameraAPIFileReadyCallBack() {  
                @Override  
                public void fileReady(File file) {  
                    if(file.exists()){  
                         //do whatever you want here!
                     }  
                }  
            });   
         }  
      });
 
Connect with me on [LinkedIn](https://www.linkedin.com/in/gihansandaru/)

