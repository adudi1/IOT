import QtQuick 2.0
import DecodedInfoScreenVM 1.0
Item {
    anchors.fill: parent
    DecodedInfoScreenVM{
     id:_decodedInfoScreenVM
     onInfoChanged: {
         console.log("here"+info)
         _textInfo.text = info
     }
    }
        Text
        {
            id: _textInfo
            wrapMode: Text.Wrap
            font.pixelSize: 20
            anchors.verticalCenter: parent.verticalCenter
            anchors.horizontalCenter: parent.horizontalCenter
            horizontalAlignment: Text.AlignHCenter
            text: _decodedInfoScreenVM.info
        }
}
