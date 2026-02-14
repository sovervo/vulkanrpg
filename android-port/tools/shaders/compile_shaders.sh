#!/usr/bin/env bash
set -euo pipefail

SRC_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/../../app/src/main/cpp/shaders" && pwd)"
OUT_DIR="$SRC_DIR/spv"
mkdir -p "$OUT_DIR"

glslangValidator -V "$SRC_DIR/sprite.vert" -o "$OUT_DIR/sprite.vert.spv"
glslangValidator -V "$SRC_DIR/sprite.frag" -o "$OUT_DIR/sprite.frag.spv"

echo "Compiled shaders to $OUT_DIR"
