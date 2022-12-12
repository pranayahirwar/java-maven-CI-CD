def devStep() {
    echo "This is build process"
}

def  testStep() {
    echo "Here testing take place"
}

def beforProd() {
    echo "Final rechecking before Production"
    // echo "You have chosen ${params.VERSION} during build"
}


return this
