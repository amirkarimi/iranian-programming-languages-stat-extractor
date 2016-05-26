## What is this
Several month ago a [famous member](http://jadi.net/) of open-source community of Iran [announced](http://jadi.net/2016/02/itstatus1394/) a questionnaire for Iranian developers and sys-admins.

Some of it's data can't be visualized using LibreOffice/Excel easily; like the programming language popularity. I've written this simple app in my favorite language Scala to transfer those data to a more convenient format to be visualized. Code talks it self.

You can download the original data file of the questionnaire result from [here](http://jadi.net/files/iran_it_status_1394_detail_data_jadi_net.tsv).

Thanks Jadi ;)

## Run

* [Install SBT](http://www.scala-sbt.org/download.html)
* Clone this project
* Run the project: `sbt "run [input-file-path] [output-file-path]"`
