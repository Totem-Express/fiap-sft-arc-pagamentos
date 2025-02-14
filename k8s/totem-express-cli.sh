#!/bin/bash
# TODO: config aws aqui

RESOURCE_FILES=(
"totem-express-payments-deployment.yaml"
"totem-express-payments-hpa.yaml"
"totem-express-payments-secret.yaml"
"totem-express-payments-service.yaml")

for FILE in "${RESOURCE_FILES[@]}"; do
  if [ -f "$FILE" ]; then
    echo "Aplicando $FILE..."
    kubectl apply -f "$FILE"
  else
    echo "$FILE não encontrado!"
  fi
done

# TODO: EXTERNAL_IP aqui