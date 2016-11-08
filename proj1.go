/*
* Finding all duplicate files in a folder and group them by readable output
* 
* Idea: To avoid O(n^2), I used "map" to automatically grouping identical files
*
* proj1.go
*
* @Yilun Qian
*
*/
package main

import (
	"fmt"
	"os"
	"path/filepath"
	"strings"
	"crypto/sha256"
	"flag"
	"io/ioutil"    
    "log"
    "encoding/hex"
    "reflect"
)

type Tuple struct {
	pathName string
	hashValue string
}

// type manytuplePointers []*Tuple 

var tuples []Tuple // save Objects
var counter int

func printType(){
	fmt.Println(reflect.TypeOf(tuples))
}

func walkFunction(path string, f os.FileInfo, err error) error {
	if (!f.IsDir() && !strings.Contains(path, ".DS_Store")) {
		// .DS_Store is a file that stores custom attributes of its containing folder in Mac
		// https://en.wikipedia.org/wiki/.DS_Store
		t := Tuple{}
		t.pathName = path

		t.hashValue = hash256(path)

		// push one tuple into tuples
		tuples = append(tuples, t)

		counter++
	}
	return nil
}

func hash256(path string) string{
	hasher := sha256.New()
    s, err := ioutil.ReadFile(path)    
    hasher.Write(s)
    if err != nil {
        log.Fatal(err)
    }

    h_value := hex.EncodeToString(hasher.Sum(nil))
    return h_value
}

func compareByMapping() {
	mappingWithRepeat := make(map[string] string)
	noRepeat := make(map[string] string)
	
	for _, t := range tuples {
		
		if mappingWithRepeat[t.hashValue] == "" {
			mappingWithRepeat[t.hashValue] = t.pathName + "\n"	
		} else {
			mappingWithRepeat[t.hashValue] += t.pathName + "\n"
			noRepeat[t.hashValue] = mappingWithRepeat[t.hashValue]
		}

	}

	groupNum := 1
	for _, s := range noRepeat {
		fmt.Println("***** Group", groupNum, "*****", "\n" + s)
		c := counteElements(s)
		fmt.Println("<< So, group", groupNum," has: ", c, "repeated files", "\n  \n")
		groupNum++
	}

}

func counteElements(str string) int{
	c := 0
	for _, s := range str {
		if s == '\n' {
			c++
		}
	}
	return c
}

func main() {
	flag.Parse()
	root := flag.Arg(0)
	err := filepath.Walk(root, walkFunction)
	compareByMapping()
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(err)

	printType()

	// us := manytuplePointers{{"a", "b"},
	// 				{"c", "d"},	
	// 				}

	// fmt.Println(us[0])
}