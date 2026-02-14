$src = Resolve-Path "$PSScriptRoot/../../app/src/main/cpp/shaders"
$out = "$src/spv"
New-Item -ItemType Directory -Force -Path $out | Out-Null

glslangValidator -V "$src/sprite.vert" -o "$out/sprite.vert.spv"
glslangValidator -V "$src/sprite.frag" -o "$out/sprite.frag.spv"
Write-Host "Compiled shaders to $out"
