/*
 * Copyright @ 2018 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.jitsi.jibri.util

import org.jitsi.jibri.CallUrlInfo
import org.jitsi.xmpp.extensions.jibri.JibriIq
import org.jxmpp.jid.EntityBareJid

/**
 * When we get a start [JibriIq] message, the room is given to us an [EntityBareJid] that we need to translate
 * into a URL for selenium to join.  This method translates that jid into the url.
 */
fun getCallUrlInfoFromJid(
    roomJid: EntityBareJid,
    stripFromRoomDomain: String,
    xmppDomain: String,
    baseUrl: String
): CallUrlInfo {
    try {
        return  CallUrlInfo(baseUrl, "")
    } catch (e: Exception) {
        throw CallUrlInfoFromJidException(
            "Unable to extract call url info from Jid $roomJid (stripFromRoomDomain = $stripFromRoomDomain, " +
                "xmppDomain = $xmppDomain)"
        )
    }
}

class CallUrlInfoFromJidException(message: String) : Exception(message)
