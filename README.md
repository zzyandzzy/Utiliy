# Utiliy

[![MIT License][101]][102]

**Retorfit** + **RxAndroid** and more library


## SetUp

**To use this library your minSdkVersion must be >= 21.**

### Gradle

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
		repositories {			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency
```gradle
dependencies {
    compile 'com.github.zzyandzzy:utiliy:0.0.1'
}
```

### Maven

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file
```xml
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

Step 2. Add the dependency
```xml
	<dependency>
	    <groupId>com.github.zzyandzzy</groupId>
	    <artifactId>Utiliy</artifactId>
	    <version>test</version>
	</dependency>
```

## Usage

**net**

[RetrofitHttpUtils]([400])

*get* url return `okhttp3.ResponseBody`
```java
RetrofitHttpUtils.staticDoGetUrl("http://www.zzyandzzy.xyz/")
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        LogUtils.v(responseBody.string());
                    }
                });
```
if return Json,please use `staticDoGetUrlToJson`

**widget**

[ImageViewUtils]([401])

*setImageViewBitmap*
```java
ImageViewUtils.setImageBitmap(iv1,"https://avatars1.githubusercontent.com/u/14029779?v=4&s=460");
```

## Licence
```licence
MIT License

Copyright (c) 2017 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

[101]: https://img.shields.io/github/license/HeinrichReimer/material-intro.svg
[102]: https://mit-license.org/
[400]: https://github.com/zzyandzzy/Utiliy/blob/master/library/src/main/java/xyz/zzyandzzy/utiliy/net/RetrofitHttpUtils.java
[401]: https://github.com/zzyandzzy/Utiliy/blob/master/library/src/main/java/xyz/zzyandzzy/utiliy/widget/ImageViewUtils.java
