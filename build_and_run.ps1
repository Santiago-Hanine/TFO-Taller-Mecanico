# build_and_run.ps1
# Script simple para compilar y ejecutar el proyecto Java desde PowerShell
# Uso: Ejecutar en la raíz del proyecto (donde está la carpeta src)

param()

$srcDir = Join-Path $PSScriptRoot 'src'
$outDir = Join-Path $PSScriptRoot 'out'

Write-Host "Usando JDK:"
java --version

if (-Not (Test-Path $srcDir)) {
    Write-Error "No se encontró la carpeta src en $PSScriptRoot"
    exit 1
}

if (-Not (Test-Path $outDir)) {
    New-Item -ItemType Directory -Path $outDir | Out-Null
}

# Recolectar fuentes .java
$files = Get-ChildItem -Path $srcDir -Recurse -Filter '*.java' | ForEach-Object { $_.FullName }
if ($files.Count -eq 0) {
    Write-Error "No se encontraron archivos .java en $srcDir"
    exit 1
}

Write-Host "Compilando $($files.Count) archivos..."
javac -d "$outDir" $files
if ($LASTEXITCODE -ne 0) {
    Write-Error "Errores de compilación. Revisa la salida anterior."
    exit $LASTEXITCODE
}

Write-Host "Compilación OK. Ejecutando App..."
# Ejecutar la clase principal (App en paquete default)
java -cp "$outDir" App

if ($LASTEXITCODE -ne 0) {
    Write-Error "La ejecución devolvió código de salida $LASTEXITCODE"
    exit $LASTEXITCODE
}

Write-Host "Ejecución finalizada."