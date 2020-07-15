ImageConv

A very simple image conversion tool I wrote as a front-end to utilize a new ImageIO-API compatible reader and writer for the somewhat esoteric *.i64 file format as used in the Bally/Williams Pinball 2000 line of products for tournament participants' image data.

To Build:
1. Install [My fork of TwelveMonkeys](https://github.com/enver-haase/TwelveMonkeys), using  `mvn install` in that project
2. `mvn package`
3. `mv target/ImageConv-1.0-SNAPSHOT-jar-with-dependencies.jar imgconv.jar`

To Use:
`java -jar imgconv.jar file.bmp` views an image;
`java -jar imgconv.jar file.bmp file.i64` converts an image.

Have fun!

Enver Haase <enver.haase@infraleap.com>
20200715
