
# Explanation of my design and assumptions

I have created ***BackBaseWidgetModule*** which have two component ***AccountTitle*** and ***AccountText***.

So My focus was just in this module, which I will explain more in BackBaseWidgetModule section.

Besides this module I have created a simple app which have the same UI as the pdf screenshot, so you can run the app and see the result.

 
# BackBaseWidgetModule


There are **Two** components in this module **AccountTitle** and **AccountText** .

## AccountTitle:
this compund view has two atteributes **title** and **description** which are strings and can be set via xml and code.

## AccountText:
this compund view has two atteributes **amount** and **design**.

**amount** must be float and can be set via xml and code.

**design** is enum and has two mode, ***symbol*** and **code**, in order to show ***€*** or **EUR**.


## Use in application scope:
in order to set the **design** atteributes globally in the application you can set this atteribute in the paraten style or theme of the application

```xml
 <style name="yourTheme" parent="Theme...">
   <!-- Customize your theme -->
   <item name="design">symbol</item>
 </style>
```

