/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2017 Yegor Bugayenko
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 */
package hangman;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class Main {

    private final InputStream input;
    private final OutputStream output;
    private final int max;

    public Main(final InputStream in, final OutputStream out, final int m) {
        this.input = in;
        this.output = out;
        this.max = m;
    }

    public static void main(final String... args) {
        new Main(System.in, System.out, 5).exec();
    }

    public void exec() {
        List<String> words = Arrays.asList("simplicity", "equality", "grandmother",
                "neighborhood", "relationship", "mathematics",
                "university", "explanation");
        Word word = new CachedWord(new RandomWord(words));
        PlayerMessageChannel playerOutput = new PlayerMessageChannel(this.output);
        new FinalResult(
                new Game(
                        new Guess(this.input, playerOutput),
                        new GameStatus(word),
                        max
                ),
                playerOutput,
                word).announce();
    }

}
