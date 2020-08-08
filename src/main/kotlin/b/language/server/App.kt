package b.language.server

import org.eclipse.lsp4j.jsonrpc.Launcher
import org.eclipse.lsp4j.launch.LSPLauncher
import org.eclipse.lsp4j.services.LanguageClient
import java.io.InputStream
import java.io.OutputStream
import java.util.concurrent.Future


fun main() {
    startServer(System.`in`, System.out)
}

fun startServer(inputStream: InputStream, outputStream: OutputStream){
    val server = Server()
    val launcher : Launcher<LanguageClient> = LSPLauncher.createServerLauncher(server, inputStream, outputStream)
    val startListing : Future<*> = launcher.startListening()

    server.setRemoteProxy(launcher.remoteProxy)
    startListing.get()
}