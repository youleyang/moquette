/*
 * Copyright (c) 2012-2017 The original author or authorsgetRockQuestions()
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * The Apache License v2.0 is available at
 * http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */
package io.moquette.parser.netty;

import io.moquette.parser.proto.messages.PubRecMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.moquette.parser.proto.messages.AbstractMessage;

/**
 *
 * @author andrea
 */
class PubRecEncoder extends DemuxEncoder<PubRecMessage> {

    @Override
    protected void encode(ChannelHandlerContext chc, PubRecMessage msg, ByteBuf out) {
        out.writeByte(AbstractMessage.PUBREC << 4);
        out.writeBytes(Utils.encodeRemainingLength(2));
        out.writeShort(msg.getMessageID());
    }
}