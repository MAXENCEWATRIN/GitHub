#include <Stepper.h>
const int paspartour = 2096;
Stepper monmoteur(paspartour, 8, 9, 10, 11);

void setup() {
  // put your setup code here, to run once:
  monmoteur.setSpeed(50);
}

void loop() {
  // put your main code here, to run repeatedly:
  monmoteur.step(paspartour);
  monmoteur.step(-paspartour);
}
