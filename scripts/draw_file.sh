case $1 in

  "-d")
  echo Oui
  ;;
  "--help" | "-h")
  echo
  ;;
  *)
    echo Non
  ;;
esac
# command 1 || command 2 -> Si la commande 1 error command 2 est exécutée