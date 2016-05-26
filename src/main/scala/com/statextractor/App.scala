package com.statextractor

import scala.io.Source
import java.io._

object Hello {
  def main(args: Array[String]): Unit = {
    if (args.length < 2) {
      println("Usage: stat-extractor [input-tsv/csv-file] [output-csv-file]")
    } else {
      extractData(inputFilePath = args(0), outputFilePath = args(1))
    }
  }
  
  def extractData(inputFilePath: String, outputFilePath: String): Unit = {
    val source = Source.fromFile(inputFilePath)
    
    // Drop the header row
    val lines = source.getLines.drop(1).toSeq
    
    // Use all your CPUs. It's 2016!
    val parallelSeq = lines.par
    
    // Split items
    val splittedItems = parallelSeq flatMap { line =>
      line.split(',').map(_.trim)
    }
    
    // Group by language name and return the count of each one
    val groupedItems = splittedItems.filter(_.nonEmpty).groupBy(identity) map { case (key, items) =>
      (key, items.length)
    }
    
    // Write to output file
    val writer = new PrintWriter(new File(outputFilePath))
    
    try {
      // Header
      writer.println("Language,Count")
      
      // Body
      groupedItems map { 
        case (language, count) => writer.println(s"${language},${count}")
      }
    } finally {
      // Close
      writer.close()
    }
    
    println(s"${lines.length} item(s) proccessed.")
  }
}
