#!/bin/bash

# Configuration
APP_NAME="task-tracker"
INSTALL_DIR="$HOME/.task-tracker-cli"
BIN_DIR="$HOME/.local/bin"

echo "Installing $APP_NAME..."

# 1. Compile the project
echo "Compiling Java files..."
mkdir -p bin
javac -d bin -cp "lib/gson.jar" src/*.java
if [ $? -ne 0 ]; then
    echo "Error: Compilation failed."
    exit 1
fi

# 2. Create installation directory
echo "Creating installation directory: $INSTALL_DIR"
mkdir -p "$INSTALL_DIR"

# 3. Move files to installation directory
echo "Copying files to $INSTALL_DIR..."
cp bin/*.class lib/gson.jar task-tracker "$INSTALL_DIR/"

# 4. Create bin directory if it doesn't exist
mkdir -p "$BIN_DIR"

# 5. Create symbolic link in BIN_DIR
echo "Creating symbolic link in $BIN_DIR..."
ln -sf "$INSTALL_DIR/task-tracker" "$BIN_DIR/$APP_NAME"

# 6. Set permissions
chmod +x "$INSTALL_DIR/task-tracker"

echo ""
echo "Installation complete!"
echo "Please ensure $BIN_DIR is in your PATH."
echo "You can now use the tool by typing: $APP_NAME"
