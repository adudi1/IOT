import QtQuick 2.0
//import QZXing 2.3
import QtMultimedia 5.5
import CameraScreenVM 1.0

Item {
    anchors.fill: parent
    property string info: ""

    Rectangle
    {
        id: bgRect
        color: "white"
        anchors.fill: videoOutput
    }

    Text
    {
        id: text1
        wrapMode: Text.Wrap
        font.pixelSize: 20
        anchors.top: parent.top
        anchors.left: parent.left
        z: 50
        text: "..."
    }

    Camera
    {
        id:camera
    }

    VideoOutput
    {
        id: videoOutput
        source: camera
        anchors.top: text1.bottom
        anchors.bottom: parent.bottom
        anchors.left: parent.left
        anchors.right: parent.right
        filters: [ zxingFilter ]
    }

    CameraScreenVM
    {
        id: zxingFilter

        onTagFound:
        {
            text1.text = tag;
            window.decoded(tag);
        }
    }



}
