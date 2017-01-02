import QtQuick 2.5
import QtQuick.Controls 1.4
import QtQuick.Layouts 1.1
import QtQuick.Dialogs 1.2
import QtQuick.Window 2.0
import MainWindowVM 1.0
import "../ui_qml/screens"

ApplicationWindow
{
    id: window
    visible: true
    width: Screen.desktopAvailableWidth
    height: Screen.desktopAvailableHeight
    title: "LAC Qr Code Reader"

    signal decoded(var info);

    MainWindowVM{
        id: _mainWindowVM
        onPageUrlChanged: {
            _loader.setSource(pageUrl)
        }
    }

    Loader{
        id: _loader
        anchors.fill: parent
        source: _mainWindowVM.pageUrl
    }

}
