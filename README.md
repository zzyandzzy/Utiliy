# Utiliy

[![MIT License][101]][102]

**Retorfit** + **RxAndroid** and more library

##Use

**Http**

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

**ImageView**

*setImageViewBitmap*
```java
ImageViewUtils.setImageBitmap(iv1,"https://avatars1.githubusercontent.com/u/14029779?v=4&s=460");
```

##Dependency

**Gradle**

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
		repositories {
			...
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

**Maven**

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

[101]: https://img.shields.io/github/license/HeinrichReimer/material-intro.svg
[102]: https://mit-license.org/
