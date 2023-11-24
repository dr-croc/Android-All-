void main(){

  printConsole("shykat");
}

void printConsole( String name,  {String extraValue = "Hola", String? et_2} ){
  print(name);
  print(extraValue);
  print(et_2);
}

int multiply(int a, int b){
  return a * b;
}

// output 
shykat
Hola
null
